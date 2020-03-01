package com.example.musicalstructureaudiobooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button nowPlayingBtn;
    Intent playerActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        nowPlayingBtn = findViewById(R.id.now_playing_btn);

        final ArrayList<Book> booksList = new ArrayList<>();

        booksList.add(new Book(R.drawable.book1, getString(R.string.seven_habits_book), getString(R.string.Stephen_Covey)));
        booksList.add(new Book(R.drawable.book2, getString(R.string.awaken_the_giant_within_book), getString(R.string.Tony_Robbins)));
        booksList.add(new Book(R.drawable.book3, getString(R.string.get_out_book), getString(R.string.mark_philip)));

        BookAdapter bookAdapter = new BookAdapter(MainActivity.this, booksList);
        GridView listView = findViewById(R.id.list);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                playerActivityIntent = new Intent(MainActivity.this, MediaPlayerActivity.class);

                playerActivityIntent.putExtra("bookImage", booksList.get(position).getImageResourceId());
                playerActivityIntent.putExtra("bookTitle", booksList.get(position).getTitle());
                playerActivityIntent.putExtra("bookAuthor", booksList.get(position).getAuthor());

                startActivity(playerActivityIntent);
            }
        });

        nowPlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if (intent != null){
                    int bookImage = intent.getIntExtra("bookImage", 0);
                    String bookTitle = intent.getStringExtra("bookTitle");
                    String bookAuthor = intent.getStringExtra("bookAuthor");

                    playerActivityIntent = new Intent(MainActivity.this, MediaPlayerActivity.class);
                    playerActivityIntent.putExtra("bookImage", bookImage);
                    playerActivityIntent.putExtra("bookTitle", bookTitle);
                    playerActivityIntent.putExtra("bookAuthor", bookAuthor);
                    startActivity(playerActivityIntent);
                }else
                    startActivity(playerActivityIntent);
            }
        });
    }
}
