package com.epicodus.herosquare.models;

import org.parceler.Parcel;

@Parcel
public class Hero {
    String name;
    String aliases;
    String realName;
    String description;
    String bio;
    String iconImageUrl;
    String screenImageUrl;
    String origin;
    int popularity;
    private String pushId;

    public Hero(){}

    public Hero(String name, String aliases, String realName, String description, String bio, String iconImageUrl, String screenImageUrl, String origin, int popularity) {
        this.name = name;
        this.aliases = aliases;
        this.realName = realName;
        this.description = description;
        this.bio = bio;
        this.iconImageUrl = iconImageUrl;
        this.screenImageUrl = screenImageUrl;
        this.origin = origin;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public String getAliases() { return aliases; }

    public String getDescription() {
        return description;
    }

    public String getRealName() {
        return realName;
    }

    public String getBio() {
        return bio;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public String getScreenImageUrl() { return screenImageUrl; }

    public String getOrigin() {
        return origin;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
