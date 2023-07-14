package com.example.lampungmarket.api;

import com.example.lampungmarket.models.DefaultResponse;
import com.example.lampungmarket.models.GetAllShopRequest;
import com.example.lampungmarket.models.GetAllShopResponse;
import com.example.lampungmarket.models.LoginRequest;
import com.example.lampungmarket.models.LoginResponse;
import com.example.lampungmarket.models.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("user")
    Call<DefaultResponse> registerUser(
            @Body RegisterRequest request
    );

    @POST("auth")
    Call<LoginResponse> loginUser(
            @Body LoginRequest request
    );

    @POST("shop")
    Call<GetAllShopResponse> getAllShop(
            @Body GetAllShopRequest request
    );
}
