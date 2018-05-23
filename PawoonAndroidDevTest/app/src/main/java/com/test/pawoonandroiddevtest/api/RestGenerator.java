package com.test.pawoonandroiddevtest.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestGenerator {
    public static final String baseUrl="http://jsonplaceholder.typicode.com/";
    private static OkHttpClient.Builder httpClient;

    public static <S> S createService(Class<S> serviceClass) {
        httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(baseUrl)
                .client(httpClient.build()).addConverterFactory(GsonConverterFactory.create());
        Retrofit restAdapter = builder.build();
        return restAdapter.create(serviceClass);
    }
}

