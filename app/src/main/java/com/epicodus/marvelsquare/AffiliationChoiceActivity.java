package com.epicodus.marvelsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AffiliationChoiceActivity extends AppCompatActivity {
    @Bind(R.id.evilAffilButton) Button mEvilAffilButton;
    @Bind(R.id.goodAffilButton) Button mGoodAffilButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliation_choice);
        ButterKnife.bind(this);
    }
}
