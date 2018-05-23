package com.test.pawoonandroiddevtest;

import android.content.Context;
import android.util.Log;

import com.test.pawoonandroiddevtest.api.RestGenerator;
import com.test.pawoonandroiddevtest.api.TodoApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoRepository {

    Context context;

    public TodoRepository(Context context) {
        this.context = context;
    }

    private void getTodosFromApi() {
        TodoApi api = RestGenerator.createService(TodoApi.class);
        Call<List<Todo>> call = api.getTodo();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if(response.isSuccessful()) {
                    TodoTransact transact = new TodoTransact(context);
                    for (Todo todo: response.body()) {
                        transact.insert(todo);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }

    public List<Todo> getTodos() {
        TodoTransact transact = new TodoTransact(context);
        List<Todo> todos = transact.all();
        if(todos.isEmpty()) {
            getTodosFromApi();
            return new ArrayList<>();
        }
        else return todos;
    }

}
