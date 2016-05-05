package com.epicodus.marvelsquare.models;


public class Hero {
    private String mName;
    private String mAliases;
    private String mRealName;
    private String mDescription;
    private String mBio;
    private String mIconImageUrl;
    private String mScreenImageUrl;
    private String mOrigin;
    private int mPopularity;

    public Hero(String name, String aliases, String realName, String description, String bio, String iconImageUrl, String screenImageUrl, String origin, int popularity) {
        this.mName = name;
        this.mAliases = aliases;
        this.mRealName = realName;
        this.mDescription = description;
        this.mBio = bio;
        this.mIconImageUrl = iconImageUrl;
        this.mScreenImageUrl = screenImageUrl;
        this.mOrigin = origin;
        this.mPopularity = popularity;
    }

    public String getName() {
        return mName;
    }

    public String getAliases() { return mAliases; }

    public String getDescription() {
        return mDescription;
    }

    public String getRealName() {
        return mRealName;
    }

    public String getBio() {
        return mBio;
    }

    public String getIconImageUrl() {
        return mIconImageUrl;
    }

    public String getScreenImageUrl() { return mScreenImageUrl; }

    public String getOrigin() {
        return mOrigin;
    }

    public int getPopularity() {
        return mPopularity;
    }
}
