package com.whitney.nyaradzowalkathon.models;

public class Days {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDate;
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    public Days(String date) {
        mDate = date;
    }

    public Days(String date, int imageResourceId) {
        mDate = date;
        mImageResourceId = imageResourceId;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getDate() {
        return mDate;
    }
}