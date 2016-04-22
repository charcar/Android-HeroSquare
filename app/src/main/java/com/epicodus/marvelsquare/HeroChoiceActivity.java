package com.epicodus.marvelsquare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HeroChoiceActivity extends AppCompatActivity {
    private ListView mHeroListView;
    private String[] goodHeroListVal;
    private String [] evilHeroListVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_choice);

        mHeroListView = (ListView) findViewById(R.id.heroListView);
        goodHeroListVal = getResources().getStringArray(R.array.good_heroes);
        evilHeroListVal = getResources().getStringArray(R.array.evil_heroes);
        ArrayAdapter goodAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, goodHeroListVal);
        ArrayAdapter evilAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, evilHeroListVal);

        Intent intent = getIntent();
        String decision = intent.getStringExtra("affil");

//        if (decision.equals("good")) {
//            mHeroListView.setAdapter(goodAdapter);
//            mHeroListView.setOnItemClickListener(new AdapterView.OnItemClickListener) {
//                @Override BECAUSE ANNOTATIONS AREN'T ALLOWED HERE, HOW DO I ACCOMPLISH BRANCHING?
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                }
//            }
//        }

    }
}
