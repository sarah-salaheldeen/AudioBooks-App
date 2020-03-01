package com.example.musicalstructureaudiobooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MediaPlayerActivity extends AppCompatActivity {

    ImageView bookImageView;
    TextView titleAuthorText;
    Button backToLibraryBtn;

    private int resourceId;
    private String bookTitle;
    private String author;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent libraryIntent = new Intent(MediaPlayerActivity.this, MainActivity.class);
        libraryIntent.putExtra("bookImage", resourceId);
        libraryIntent.putExtra("bookTitle", bookTitle);
        libraryIntent.putExtra("bookAuthor", author);
        startActivity(libraryIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        Intent intent = getIntent();
        resourceId = intent.getIntExtra("bookImage", 0);
        bookTitle = intent.getStringExtra("bookTitle");
        author = intent.getStringExtra("bookAuthor");

        bookImageView = findViewById(R.id.book_image_view);
        titleAuthorText = findViewById(R.id.now_playing);

        bookImageView.setImageResource(resourceId);
        titleAuthorText.setText(String.format("%s\n%s", bookTitle, author));

        backToLibraryBtn = findViewById(R.id.library_btn);

        backToLibraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent libraryIntent = new Intent(MediaPlayerActivity.this, MainActivity.class);
                libraryIntent.putExtra("bookImage", resourceId);
                libraryIntent.putExtra("bookTitle", bookTitle);
                libraryIntent.putExtra("bookAuthor", author);
                startActivity(libraryIntent);
            }
        });


    }
}
