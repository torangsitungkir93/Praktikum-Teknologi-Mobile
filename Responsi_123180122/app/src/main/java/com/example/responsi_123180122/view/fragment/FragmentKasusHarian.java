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
import com.example.responsi_123180122.adapter.KasusAdapter;
import com.example.responsi_123180122.model.kasus.KasusDataItem;
import com.example.responsi_123180122.view.viewmodel.KasusViewModel;

import java.util.ArrayList;


public class FragmentKasusHarian extends Fragment {

    private KasusAdapter kasusHarianAdapter;
    private RecyclerView rvKasusHarian;
    private KasusViewModel kasusHarianViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kasusHarianAdapter = new KasusAdapter(getContext());
        kasusHarianAdapter.notifyDataSetChanged();

        rvKasusHarian = view.findViewById(R.id.kasusharian_rv_main);
        rvKasusHarian.setLayoutManager(new LinearLayoutManager(getContext()));

        kasusHarianViewModel = new ViewModelProvider(this).get(KasusViewModel.class);
        kasusHarianViewModel.setKasusHarianDiscover();
        kasusHarianViewModel.getKasusHarianDiscover().observe(getViewLifecycleOwner(),getKasusHarianDiscover);

        rvKasusHarian.setAdapter(kasusHarianAdapter);
    }

    private Observer<ArrayList<KasusDataItem>> getKasusHarianDiscover = new Observer<ArrayList<KasusDataItem>>() {
        @Override
        public void onChanged(ArrayList<KasusDataItem> kasusHarianDataItems) {
            if(kasusHarianDataItems != null){
                kasusHarianAdapter.setData(kasusHarianDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus_harian, container, false);
    }
}