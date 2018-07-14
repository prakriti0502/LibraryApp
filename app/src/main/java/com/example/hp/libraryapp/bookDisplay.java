package com.example.hp.libraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;

public class bookDisplay extends AppCompatActivity {
    PDFView pd;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);
        pd=     findViewById(R.id.pdfView);
        intent = getIntent();
        String bookname = intent.getStringExtra("bookname");
        if (bookname.equals("Heart of Darkness")) {
            bookname = "Black Beauty";
        }
        Log.e("Bookname",bookname);
        String pdf = bookname+".pdf";

        pd.fromAsset(pdf).load();
    }
}
