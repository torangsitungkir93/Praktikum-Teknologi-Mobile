package com.example.responsi_123180122.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public RujukanRepository getApiFasilitasKesehatan(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RujukanRepository.class);
    }

    public KasusRepository getApiKasusHarian(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(KasusRepository.class);
    }
}
