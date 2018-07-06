package com.example.hp.libraryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Booklist extends AppCompatActivity {
    /*ArrayList<String> books = new ArrayList<>();
    SQLops sqLops;*/
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        /*sqLops = new SQLops(this);*/
        //displayBooks();

        List<String> books = new ArrayList<>();
        books.add("The World As It Is: Inside the Obama White House");
        books.add("I Can't Remember If We Said Goodbye");
        books.add("Sick: A Memoir");
        books.add("A Place for Us");
        books.add("My Plain Jane");
        books.add("There There");
        books.add("Broken Lives: How Ordinary Germans Experienced the 20th Century");
        books.add("He is Enough: Living in the Fullness of Jesus");
        books.add("The Incurable Romantic and Other Tales of Madness and Desire");
        books.add("Engraved on the Heart");
        books.add("Breathless");
        books.add("Arrowheart");

        listView = findViewById(R.id.listview3);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Booklist.this,android.R.layout.simple_list_item_1,books);
        listView.setAdapter(adapter);
    }

   /* void displayBooks() {
        books = sqLops.getData("MEMOIR_and_AUTOBIOGRAPHY");
        books = sqLops.getData("FICTION");
        books = sqLops.getData("NON_FICTION");
        books = sqLops.getData("FANTASY");
    }*/
}
