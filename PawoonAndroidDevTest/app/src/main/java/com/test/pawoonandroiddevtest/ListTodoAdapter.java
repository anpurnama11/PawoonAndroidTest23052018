package com.test.pawoonandroiddevtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListTodoAdapter extends RecyclerView.Adapter<ListTodoAdapter.TodoViewHolder> {

    List<Todo>todos;

    public ListTodoAdapter(List<Todo>todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo,parent,false);
        TodoViewHolder holder = new TodoViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.bindTo(todo);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView checkMark;
        public TodoViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            checkMark = itemView.findViewById(R.id.check);
        }

        public void bindTo(Todo todo) {
            title.setText(todo.title);
            if(todo.completed)
                checkMark.setVisibility(View.VISIBLE);
            else
                checkMark.setVisibility(View.GONE);
        }
    }
}
