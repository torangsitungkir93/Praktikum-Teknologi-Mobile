package com.example.responsi_123180122.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi_123180122.R;
import com.example.responsi_123180122.adapter.RujukanAdapter;
import com.example.responsi_123180122.model.rujukan.RujukanDataItem;
import com.example.responsi_123180122.view.viewmodel.RujukanViewModel;

import java.util.ArrayList;


public class FragmentRujukan extends Fragment {

    private RujukanAdapter fasilitasKesehatanAdapter;
    private RecyclerView rvFasilitasKesehatan;
    private RujukanViewModel fasilitasKesehatanViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fasilitasKesehatanAdapter = new RujukanAdapter(getContext());
        fasilitasKesehatanAdapter.notifyDataSetChanged();

        rvFasilitasKesehatan = view.findViewById(R.id.fasilitaskesehatan_rv_main);
        rvFasilitasKesehatan.setLayoutManager(new LinearLayoutManager(getContext()));

        fasilitasKesehatanViewModel = new ViewModelProvider(this).get(RujukanViewModel.class);
        fasilitasKesehatanViewModel.setFasilitasDiscover();
        fasilitasKesehatanViewModel.getFasilitasDiscover().observe(getViewLifecycleOwner(),getFasilitasKesehatanDiscover);

        rvFasilitasKesehatan.setAdapter(fasilitasKesehatanAdapter);
    }

    private Observer<ArrayList<RujukanDataItem>> getFasilitasKesehatanDiscover = new Observer<ArrayList<RujukanDataItem>>() {
        @Override
        public void onChanged(ArrayList<RujukanDataItem> fasilitasiKesehatanDataItems) {
            if(fasilitasiKesehatanDataItems != null){
                fasilitasKesehatanAdapter.setData(fasilitasiKesehatanDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rujukan, container, false);
    }

}