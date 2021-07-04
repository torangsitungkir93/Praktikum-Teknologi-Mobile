package com.example.responsi_123180122.service;

import com.example.responsi_123180122.model.kasus.KasusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusRepository {
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<KasusResponse> getKasusHarian();
}
