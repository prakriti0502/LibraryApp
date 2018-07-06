package com.example.hp.libraryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Booklist.class);
                startActivity(intent);
            }
        });
       /* SQLops sqLops = new SQLops(this);
        sqLops.createTable("MEMOIR_and_AUTOBIOGRAPHY");
        sqLops.createTable("FICTION");
        sqLops.createTable("NON_FICTION");
        sqLops.createTable("FANTASY");
        sqLops.insert("MEMOIR_and_AUTOBIOGRAPHY","The World As It Is: Inside the Obama White House",
                "I Can't Remember If We Said Goodbye",
                "Sick: A Memoir");

        sqLops.insert("FICTION","A Place for Us",
                "My Plain Jane",
                "There There");
        sqLops.insert("NON_FICTION","Broken Lives: How Ordinary Germans Experienced the 20th Century",
                "He is Enough: Living in the Fullness of Jesus",
                "The Incurable Romantic and Other Tales of Madness and Desire");
        sqLops.insert("FANTASY","Engraved on the Heart",
                "Breathless",
                "Arrowheart");*/
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listView);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("MEMOIR and AUTOBIOGRAPHY");
        listDataHeader.add("FICTION");
        listDataHeader.add("NON FICTION");
        listDataHeader.add("FANTASY");

        // Adding child data
        List<String> mem = new ArrayList<>();
        mem.add("The World As It Is: Inside the Obama White House");
        mem.add("I Can't Remember If We Said Goodbye");
        mem.add("Sick: A Memoir");

        List<String> fic = new ArrayList<>();
        fic.add("A Place for Us");
        fic.add("My Plain Jane");
        fic.add("There There");

        List<String> nonfic = new ArrayList<>();
        nonfic.add("Broken Lives: How Ordinary Germans Experienced the 20th Century");
        nonfic.add("He is Enough: Living in the Fullness of Jesus");
        nonfic.add("The Incurable Romantic and Other Tales of Madness and Desire");

        List<String> fan = new ArrayList<>();
        fan.add("Engraved on the Heart");
        fan.add("Breathless");
        fan.add("Arrowheart");

        listDataChild.put(listDataHeader.get(0), mem); // Header, Child data
        listDataChild.put(listDataHeader.get(1), fic);
        listDataChild.put(listDataHeader.get(2), nonfic);
        listDataChild.put(listDataHeader.get(3), fan);
    }
}
