package com.test.pawoonandroiddevtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_todo);
        TodoRepository repository = new TodoRepository(this);
        List<Todo> todos = repository.getTodos();
        RecyclerView rvTodo = findViewById(R.id.rvtodo);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        ListTodoAdapter adapter = new ListTodoAdapter(todos);
        rvTodo.setLayoutManager(manager);
        rvTodo.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rvTodo.setAdapter(adapter);
    }
}
