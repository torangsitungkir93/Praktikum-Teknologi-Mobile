package com.example.responsi_123180122.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_123180122.model.kasus.KasusDataItem;
import com.example.responsi_123180122.model.kasus.KasusResponse;
import com.example.responsi_123180122.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<KasusDataItem>> listKasusHarian = new MutableLiveData<>();

    public void setKasusHarianDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasusHarian().getKasusHarian().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse kasusHarianRespone = response.body();
                if(kasusHarianRespone != null && kasusHarianRespone.getData() != null){
                    ArrayList<KasusDataItem> kasusharianItem = kasusHarianRespone.getData().getContent();
                    listKasusHarian.postValue(kasusharianItem);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<KasusDataItem>> getKasusHarianDiscover(){
        return listKasusHarian;
    }

}
