package com.vibhor.movies.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vbharadwaj on 2/11/18.
 */

public class RetrofitClient {

    private static Retrofit retrofitClient = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofitClient ==null) {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitClient;
    }
}