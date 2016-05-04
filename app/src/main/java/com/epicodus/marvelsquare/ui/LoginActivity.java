package com.epicodus.marvelsquare.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.marvelsquare.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.newAdventureTextView) TextView mNewAdventureTextView;
    @Bind(R.id.usernameEditText) EditText mUsernameEditText;
    @Bind(R.id.passwordEditText) EditText mPasswordEditText;
    @Bind(R.id.userAuthButton) Button mUserAuthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mNewAdventureTextView.setOnClickListener(this);
//        Need to send Auth credentials to session storage,
//        possibly username in top nav bar?
    }

    public void onClick(View v) {
        if(v == mNewAdventureTextView) {
            Intent intent = new Intent(LoginActivity.this, AffiliationChoiceActivity.class);
            startActivity(intent);
        }

        if(v == mUserAuthButton) {
//            Will redirect to game screen
            String username = mUsernameEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent);
        }
    }
}
