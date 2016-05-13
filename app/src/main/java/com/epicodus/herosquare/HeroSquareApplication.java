package com.epicodus.herosquare;

import android.app.Application;

import com.firebase.client.Firebase;

public class HeroSquareApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
