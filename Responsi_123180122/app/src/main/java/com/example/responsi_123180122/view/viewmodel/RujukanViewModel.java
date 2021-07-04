package com.example.responsi_123180122.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_123180122.model.rujukan.RujukanDataItem;
import com.example.responsi_123180122.model.rujukan.RujukanResponse;
import com.example.responsi_123180122.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RujukanViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<RujukanDataItem>> listFasilitas = new MutableLiveData<>();

    public void setFasilitasDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiFasilitasKesehatan().getFasilitasKesehatan().enqueue(new Callback<RujukanResponse>() {
            @Override
            public void onResponse(Call<RujukanResponse> call, Response<RujukanResponse> response) {
                RujukanResponse fasilitasDiscover = response.body();
                if(fasilitasDiscover != null && fasilitasDiscover.getData() != null){
                    ArrayList<RujukanDataItem> fasilitasiKesehatanDataItems = fasilitasDiscover.getData();
                    listFasilitas.postValue(fasilitasiKesehatanDataItems);
                }
            }

            @Override
            public void onFailure(Call<RujukanResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<RujukanDataItem>> getFasilitasDiscover(){
        return listFasilitas;
    }

}
