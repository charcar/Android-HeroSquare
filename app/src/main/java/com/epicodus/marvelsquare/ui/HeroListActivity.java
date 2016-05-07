package com.epicodus.marvelsquare.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.epicodus.marvelsquare.R;
import com.epicodus.marvelsquare.adapters.HeroListAdapter;
import com.epicodus.marvelsquare.models.Hero;
import com.epicodus.marvelsquare.services.ComicvineService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HeroListActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private HeroListAdapter mAdapter;
    public ArrayList<Hero> mHeroes = new ArrayList<>();
    public static final String TAG = HeroListActivity.class.getSimpleName();
    private ProgressDialog mQueryProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        ButterKnife.bind(this);

        mQueryProgressDialog = new ProgressDialog(this);
        mQueryProgressDialog.setTitle("Contacting the Watcher");
        mQueryProgressDialog.setMessage("Uatu sees all");
        mQueryProgressDialog.setCancelable(false);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        getHeroes(name);

        mQueryProgressDialog.show();
    }

    private void getHeroes(final String name) {
        final ComicvineService comicvineService = new ComicvineService();

         comicvineService.findCharacters(name, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mQueryProgressDialog.dismiss();
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mHeroes = comicvineService.processResults(response);
                mQueryProgressDialog.dismiss();
//                if (mHeroes.size() == 0) {
//                    Toast.makeText(HeroListActivity.this, "Unexpected issue, try a different search", Toast.LENGTH_SHORT).show();
//                } else {

                    HeroListActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new HeroListAdapter(getApplicationContext(), mHeroes);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HeroListActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);

                        }
                    });
//              } HOW TO HANDLE POOR USER QUERIES?
            }
        });
    }
}
