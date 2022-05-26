package com.example.tiktokappdev.Network;

import com.example.tiktokappdev.DataModels.MenuDataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("QmdNK6Lf5VZCc3tDsguSDnmwCRHbnCvjc2cNYefvTdnoHe")
    Call<MenuDataModel> getAllData();
}
