package com.epicodus.marvelsquare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AffiliationChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.evilTextView) TextView mEvilAffilView;
    @Bind(R.id.goodTextView) TextView mGoodAffilView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliation_choice);
        ButterKnife.bind(this);
        mEvilAffilView.setOnClickListener(this);
        mGoodAffilView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mEvilAffilView) {
            Intent intent = new Intent(AffiliationChoiceActivity.this, HeroChoiceActivity.class);
            intent.putExtra("affil", "evil");
            startActivity(intent);
        }
        if (v == mGoodAffilView) {
            Intent intent = new Intent(AffiliationChoiceActivity.this, HeroChoiceActivity.class);
            intent.putExtra("affil", "good");
            startActivity(intent);
        }
    }
}
