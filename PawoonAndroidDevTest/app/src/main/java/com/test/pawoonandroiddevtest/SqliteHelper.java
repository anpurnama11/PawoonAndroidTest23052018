package com.test.pawoonandroiddevtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME      = "todo.db";
    private static final int DATABASE_VERSION      = 1;

    private static SqliteHelper mInstance = null;

    private static final String
            TABLE_TODO = "todo",
            COLUMN_USER_ID_TODO ="userId",
            COLUMN_ID ="id",
            COLUMN_TITLE ="title",
            COLUMN_COMPLETED ="completed";

    private static final String CREATE_TABLE_TODO ="CREATE TABLE " + TABLE_TODO+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_USER_ID_TODO+" INTEGER, "+COLUMN_TITLE+" TEXT, "+COLUMN_COMPLETED+" INTEGER)";

    public static SqliteHelper getInstance(Context ctx)
    {
        if(mInstance==null) mInstance= new SqliteHelper(ctx,null,null,DATABASE_VERSION);
        return mInstance;
    }

    private SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert(String table,  ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.insert(table, null, contentValues);
        return id;
    }

    public Cursor all(String table, String order)
    {
        String query = "SELECT * FROM " + table + " ";
        if (!order.isEmpty())
        {
            query += order;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return  cursor;
    }

    public int update(String table, ContentValues contentValues, String filter)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int id = db.update(table, contentValues, filter, null);
        db.close();
        return id;
    }

    public int delete(String table, String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int result=0;
        result = db.delete(table, COLUMN_ID + "=?", new String[]{id});
        db.close();
        return result;
    }

    public int countAll(String table, String where){

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select count(*) from " + table ;
        if(!where.isEmpty()){
            sql = "select count(*) from " + table  + " where " + where;
        }
        Cursor cursorCount = db.rawQuery(sql, null);
        cursorCount.moveToFirst();
        int count = cursorCount.getInt(0);
        cursorCount.close();
        return count;
    }
    public Cursor statementRaw(String query)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public boolean truncate(String table)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(table, null, null);
        db.execSQL("VACUUM");
        return  result==1;
    }

    public Cursor get(String table, String filter, String order)
    {
        String query = "SELECT * FROM " + table + " ";
        if (!filter.isEmpty())
        {
            query += " where " + filter;
        }
        if (!order.isEmpty())
        {
            query += " " + order;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return  cursor;
    }

}

