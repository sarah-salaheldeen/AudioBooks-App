package com.example.musicalstructureaudiobooksapp;

public class Book {

    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mTitle;
    private String mAuthor;

    public Book(int imageResourceId, String title, String author){
        mImageResourceId = imageResourceId;
        mTitle = title;
        mAuthor = author;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
