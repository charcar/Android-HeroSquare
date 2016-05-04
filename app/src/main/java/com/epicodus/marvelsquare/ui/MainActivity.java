package com.epicodus.marvelsquare.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.marvelsquare.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.heroSearchEditText) EditText mHeroSearchEditText;
    @Bind(R.id.searchHeroesButton) Button mSearchHeroesButton;
    @Bind(R.id.startChoiceButton) Button mStartChoiceButton;
    @Bind(R.id.browseHeroesButton) Button mBrowseHeroesButton;
    @Bind(R.id.logInButton) Button mLogInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchHeroesButton.setOnClickListener(this);
        mStartChoiceButton.setOnClickListener(this);
        mBrowseHeroesButton.setOnClickListener(this);
        mLogInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchHeroesButton) {
            String name = mHeroSearchEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, HeroesActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
        if (v == mStartChoiceButton) {
            Intent intent = new Intent(MainActivity.this, AffiliationChoiceActivity.class);
            startActivity(intent);
        }
        if (v == mBrowseHeroesButton) {
            Intent intent = new Intent(MainActivity.this, AllHeroesActivity.class);
            startActivity(intent);
        }
        if (v == mLogInButton) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    }
}
