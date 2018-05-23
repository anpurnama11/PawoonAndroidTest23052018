package com.test.pawoonandroiddevtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class TodoTransact {
    private Context _context;
    private static final String TABLE_NAME = "todo";

    public TodoTransact(Context _context) {
        this._context = _context;
    }

    public long insert(Todo todo)
    {
        SqliteHelper dbHandler = SqliteHelper.getInstance(_context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", todo.id);
        contentValues.put("userId", todo.userId);
        contentValues.put("title", todo.title);
        contentValues.put("completed", todo.completed);
        long result = dbHandler.insert(TABLE_NAME, contentValues);
        return result;
    }

    public int update(Todo todo)
    {
        SqliteHelper dbHandler = SqliteHelper.getInstance(_context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", todo.id);
        contentValues.put("userId", todo.userId);
        contentValues.put("title", todo.id);
        contentValues.put("completed", todo.completed);
        return dbHandler.update(TABLE_NAME, contentValues, " id = " + todo.id);
    }

    public void delete(String id){
        SqliteHelper dbHandler= SqliteHelper.getInstance(_context);
        dbHandler.delete(TABLE_NAME,id);
    }

    public int countAll(){
        SqliteHelper dbHandler = SqliteHelper.getInstance(_context);
        int count = dbHandler.countAll(TABLE_NAME, "");
        return count;
    }
    public List<Todo> all(){
        SqliteHelper dbHandler = SqliteHelper.getInstance(_context);
        Cursor cursor = dbHandler.all(TABLE_NAME, " ORDER BY id DESC");
        List<Todo> todos = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                Todo todo = new Todo();
                todo.id=cursor.getInt(cursor.getColumnIndex("id"));
                todo.userId=cursor.getInt(cursor.getColumnIndex("userId"));
                todo.title=cursor.getString(cursor.getColumnIndex("title"));
                if(cursor.getInt(cursor.getColumnIndex("completed"))==1)
                    todo.completed=true;
                else
                    todo.completed=false;
                todos.add(todo);
            }while (cursor.moveToNext());
        }
        return todos;
    }

}

