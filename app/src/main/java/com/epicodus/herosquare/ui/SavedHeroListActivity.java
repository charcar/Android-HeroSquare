package com.epicodus.herosquare.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.herosquare.Constants;
import com.epicodus.herosquare.R;
import com.epicodus.herosquare.adapters.FirebaseHeroListAdapter;
import com.epicodus.herosquare.models.Hero;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedHeroListActivity extends AppCompatActivity {
    private Query mQuery;
    private Firebase mFirebaseHerosRef;
    private FirebaseHeroListAdapter mAdapter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        ButterKnife.bind(this);

        mFirebaseHerosRef = new Firebase(Constants.FIREBASE_URL_HEROES);

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery() {
        SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);
        String keyUID = sf.getString(Constants.KEY_UID, null);
        String location = mFirebaseHerosRef.child(keyUID).toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseHeroListAdapter(mQuery, Hero.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}