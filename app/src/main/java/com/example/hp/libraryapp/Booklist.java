package com.example.hp.libraryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Booklist extends AppCompatActivity {


    ArrayList<String> books;
    LinkedHashMap<String, List<String>> booksMap;
    ListView listView;
    SearchView search;
    DatabaseHelper dataBaseHelper;
    BookListAdapter bookListAdapter;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        listView = findViewById(R.id.listview3);
        dataBaseHelper = DatabaseHelper.getInstance(getApplicationContext());
        dataBaseHelper.createDatabase();
        booksMap = dataBaseHelper.fetchAll();
        books = new ArrayList<>();
        for (LinkedHashMap.Entry<String, List<String>> e : booksMap.entrySet()) {
            books.addAll(e.getValue());
        }
        listView =  findViewById(R.id.listview3);
        bookListAdapter= new BookListAdapter(books,R.layout.search_item,this);
        listView.setAdapter(bookListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long id) {
                TextView textView = (TextView) arg1.findViewById(R.id.bookname);
                Intent intent = new Intent(Booklist.this, bookDisplay.class);
                intent.putExtra("bookname", textView.getText());
                startActivity(intent);
            }
        });
        //This is wrong very wrong
        search =  findViewById(R.id.bookname);
//        search.setActivated(true);
//        search.setQueryHint("Type your keyword here");
//        search.onActionViewExpanded();
//        search.setIconified(false);
//        search.clearFocus();

//        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                bookListAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
    }
    }

