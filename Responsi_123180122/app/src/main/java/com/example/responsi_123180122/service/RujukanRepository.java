package com.example.responsi_123180122.service;

import com.example.responsi_123180122.model.rujukan.RujukanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RujukanRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<RujukanResponse> getFasilitasKesehatan();
}
