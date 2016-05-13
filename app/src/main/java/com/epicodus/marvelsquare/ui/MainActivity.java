package com.epicodus.marvelsquare.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.epicodus.marvelsquare.Constants;
import com.epicodus.marvelsquare.R;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.heroSearchEditText) EditText mHeroSearchEditText;
    @Bind(R.id.searchHeroesButton) Button mSearchHeroesButton;
    @Bind(R.id.startChoiceButton) Button mStartChoiceButton;
    @Bind(R.id.browseHeroesButton) Button mBrowseHeroesButton;
    @Bind(R.id.logInButton) Button mLogInButton;
    private Firebase mFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFirebaseRef = new Firebase(Constants.FIREBASE_URL);

        mSearchHeroesButton.setOnClickListener(this);
        mStartChoiceButton.setOnClickListener(this);
        mBrowseHeroesButton.setOnClickListener(this);
        mLogInButton.setOnClickListener(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("message");
        if (name != null) {
            Toast toast = Toast.makeText(MainActivity.this,
                    "Invalid Search", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER| Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchHeroesButton) {
            String name = mHeroSearchEditText.getText().toString();

            Intent intent = new Intent(MainActivity.this, HeroListActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void logout() {
        mFirebaseRef.unauth();
    }

}
