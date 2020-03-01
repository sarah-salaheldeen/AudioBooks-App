package com.example.musicalstructureaudiobooksapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Activity context, ArrayList<Book> books){
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Book currentBook = getItem(position);

        ImageView bookImage =listItemView.findViewById(R.id.book_image_view);
        if (currentBook.hasImage()) {
            bookImage.setImageResource(currentBook.getImageResourceId());
            bookImage.setVisibility(View.VISIBLE);
        } else {
            bookImage.setVisibility(View.GONE);
        }

        TextView titleTextView = listItemView.findViewById(R.id.book_title_text_view);
        titleTextView.setText(currentBook.getTitle());

        TextView authorTextView = listItemView.findViewById(R.id.book_author_text_view);
        authorTextView.setText(currentBook.getAuthor());

        return listItemView;
    }
}
