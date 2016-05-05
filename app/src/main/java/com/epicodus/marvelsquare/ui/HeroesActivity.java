package com.epicodus.marvelsquare.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.marvelsquare.R;
import com.epicodus.marvelsquare.models.Hero;
import com.epicodus.marvelsquare.services.ComicvineService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HeroesActivity extends AppCompatActivity {
    public ArrayList<Hero> mHeroes = new ArrayList<>();
    public static final String TAG = HeroesActivity.class.getSimpleName();
    @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        getHeroes(name);
    }

    private void getHeroes(final String name) {
        final ComicvineService comicvineService = new ComicvineService();

         comicvineService.findCharacters(name, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mHeroes = comicvineService.processResults(response);

                HeroesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] heroNames = new String[mHeroes.size()];
                        for (int i = 0; i < heroNames.length; i++) {
                            heroNames[i] = mHeroes.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(HeroesActivity.this, android.R.layout.simple_list_item_1, heroNames);
                        mListView.setAdapter(adapter);

                        for (Hero hero : mHeroes) {
                            Log.d(TAG, "Aliases: " + hero.getAliases());
                        }
                    }
                });

            }
        });
    }
}
