package com.epicodus.marvelsquare.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.marvelsquare.Constants;
import com.epicodus.marvelsquare.R;
import com.epicodus.marvelsquare.models.Hero;
import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HeroDetailFragment extends Fragment implements View.OnClickListener {
    private SharedPreferences mSharedPreferences;
    private static final int MAX_WIDTH = 450;
    private static final int MAX_HEIGHT = 350;

    @Bind(R.id.bannerHeroImageView) ImageView mBannerImageLabel;
    @Bind(R.id.heroNameTextView) TextView mHeroNameLabel;
    @Bind(R.id.realNameTextView) TextView mRealNameLabel;
    @Bind(R.id.popularityTextView) TextView mPopularityLabel;
    @Bind(R.id.originTextView) TextView mOriginLabel;
    @Bind(R.id.aliasTextView) TextView mAliasLabel;
    @Bind(R.id.bioTextView) TextView mBioLabel;
    @Bind(R.id.fullDescriptionTextView) TextView mFullDescriptionLabel;
    @Bind(R.id.saveHeroButton) Button mSaveHeroButton;
    @Bind(R.id.logInCreateAccountButton) Button mLogInCreateAccountButton;

    private Hero mHero;

    public static HeroDetailFragment newInstance(Hero hero) {
        HeroDetailFragment heroDetailFragment = new HeroDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("hero", Parcels.wrap(hero));
        heroDetailFragment.setArguments(args);
        return heroDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHero = Parcels.unwrap(getArguments().getParcelable("hero"));
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_detail, container, false);
        ButterKnife.bind(this, view);
        mSaveHeroButton.setOnClickListener(this);

        Picasso.with(view.getContext())
                .load(mHero.getScreenImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mBannerImageLabel);

        mHeroNameLabel.setText(mHero.getName());
        mRealNameLabel.setText(mHero.getRealName());
        mPopularityLabel.setText(Integer.toString(mHero.getPopularity()));
        mOriginLabel.setText(mHero.getOrigin());
        mAliasLabel.setText(mHero.getAliases());

        mFullDescriptionLabel.setText(mHero.getDescription());

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String uid = prefs.getString(Constants.KEY_UID, null);
        Log.d("Shared Preferences", uid + "");

        if ("notLogged".equals(uid)) {
            mLogInCreateAccountButton.setVisibility(View.VISIBLE);
        }
        if (uid != "notLogged") {
            mSaveHeroButton.setVisibility(View.VISIBLE);
        }



        return view;
    }

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

//    Note: After user has chosen hero, dialogfragment appears asking them if they'd like to 'share'
//    their choice via implicit intent either through text or social media. I would like to figure
//    out how to pass the hero name to the dialogFragment from this fragment, and then either pass
//    that along with some text into an implicit intent, or give user the option to continue along
//    with the rest of the app

    @Override
    public void onClick(View v) {
        if (v == mSaveHeroButton) {
            String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
            Firebase userHeroesFirebaseRef = new Firebase(Constants.FIREBASE_URL_HEROES).child(userUid);
            Firebase pushRef = userHeroesFirebaseRef.push();
            String heroesPushId = pushRef.getKey();
            mHero.setPushId(heroesPushId);
            pushRef.setValue(mHero);
            Toast.makeText(getContext(), "Well Chosen", Toast.LENGTH_SHORT).show();
        }
    }

}
