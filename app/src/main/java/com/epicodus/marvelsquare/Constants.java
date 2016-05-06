package com.epicodus.marvelsquare;


public class Constants {
    public static final String COMICVINE_KEY = BuildConfig.COMICVINE_KEY;
    public static final String COMICVINE_BASE_URL = "http://www.comicvine.com/api/characters/";
    public static final String COMICVINE_SEARCH_LIMIT = "limit";
    public static final String COMICVINE_FORMAT = "format";
    public static final String COMICVINE_JSON = "json";
    public static final String COMICVINE_CHARACTER_QUERY_PARAMETER = "filter";
    public static final String COMICVINE_NAME_SIGNIFIER = "name:";

    public static final String FIREBASE_URL =  BuildConfig.FIREBASE_ROOT_URL;

    public static final String FIREBASE_HERO_CHOSEN = "heroes";
    public static final String FIREBASE_URL_HEROES = FIREBASE_URL + "/" + FIREBASE_HERO_CHOSEN;

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;


}
