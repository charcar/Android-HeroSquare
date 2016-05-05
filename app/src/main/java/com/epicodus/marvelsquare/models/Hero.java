package com.epicodus.marvelsquare.models;


public class Hero {
    private String mName;
    private String mRealName;
    private String mDescription;
    private String mBio;
    private String mImageUrl;
    private String mOrigin;
    private int mPopularity;

    public Hero(String name, String realName, String description, String bio, String imageUrl, String origin, int popularity) {
        this.mName = name;
        this.mRealName = realName;
        this.mDescription = description;
        this.mBio = bio;
        this.mImageUrl = imageUrl;
        this.mOrigin = origin;
        this.mPopularity = popularity;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getRealName() {
        return mRealName;
    }

    public String getBio() {
        return mBio;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public int getPopularity() {
        return mPopularity;
    }
}
