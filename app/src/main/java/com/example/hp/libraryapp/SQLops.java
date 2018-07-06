package com.example.hp.libraryapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SQLops {
    Context context;
    SQLiteDatabase db;

    SQLops(Context context) {
        this.context = context;
        db = context.openOrCreateDatabase("userDB",MODE_PRIVATE,null);
    }

    void createTable(String tablename) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS " +tablename+ "(book VARCHAR)");
        } catch (Exception e) {
            throw e;
        }
    }
    void insert(String tablename,String book1,String book2,String book3) {

        db.execSQL("INSERT INTO " +
                  tablename  + " VALUES ('" +book1+book2+book3+ "') " );

    }
     ArrayList<String> getData(String table) {
        Cursor c = db.rawQuery("SELECT * FROM " + table + "",null);
        ArrayList<String> list1 = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                int index = c.getColumnIndex("book");
                String note = c.getString(index);
                list1.add(note);
            } while (c.moveToNext());
        }
        return  list1;
    }
}
