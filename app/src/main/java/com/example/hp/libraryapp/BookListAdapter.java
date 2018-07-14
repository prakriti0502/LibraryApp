package com.example.hp.libraryapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookListAdapter extends ArrayAdapter<String> implements Filterable {
    private Context context;
    List<String> books;
    int res;
    List<String> booksFilterList;
    BookFilter bookFilter;
    private LayoutInflater inflater;



    public BookListAdapter(ArrayList<String> bookList, int res,Context context) {
        super(context,res,bookList);
        books= bookList;
        booksFilterList= bookList;
        this.res = res;
        this.context = context;
    }




    @Override
    public View getView(int position, View view, final ViewGroup parent) {
        String text = books.get(position);

        if(view == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(res, parent,false);
        }

        TextView textView = (TextView) view.findViewById(R.id.bookname);
        textView.setText(text);
        return view;
    }

    @Override
    public Filter getFilter() {
        if (bookFilter == null) {
            bookFilter = new BookFilter();
        }
        return bookFilter;
    }

    private class BookFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<String> filterList = new ArrayList<>();
                for (int i = 0; i < booksFilterList.size(); i++) {
                    if ((booksFilterList.get(i).toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(booksFilterList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = booksFilterList.size();
                results.values = booksFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            books = (List<String>) results.values;
            notifyDataSetChanged();
        }

    }
}
