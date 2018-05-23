package com.test.pawoonandroiddevtest.api;

import com.test.pawoonandroiddevtest.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoApi {
    @GET("todos")
    Call<List<Todo>> getTodo();
}
