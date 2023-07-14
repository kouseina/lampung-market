package com.example.lampungmarket.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    final static String BASE_URL = "https://lampungmarket-api.vercel.app/api/";

    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder().method(original.method(), original.body());
                requestBuilder.addHeader("Content-Type", "application/json");

                Request request = requestBuilder.build();

                return chain.proceed(request);
            });

    public static Api instance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();

        return retrofit.create(Api.class);
    }
}
