package com.example.tiktokappdev.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("QmdNK6Lf5VZCc3tDsguSDnmwCRHbnCvjc2cNYefvTdnoHe")
    Call<Model> getAllData();
}
