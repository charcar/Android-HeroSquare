package com.epicodus.marvelsquare.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.marvelsquare.R;
import com.epicodus.marvelsquare.models.Hero;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HeroDetailFragment extends Fragment {
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_detail, container, false);
        ButterKnife.bind(this, view);


//        SHOULD THIS BE WHERE I PARSE OUT THE HTML FROM THE API CALL?
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
        mBioLabel.setText(mHero.getBio());
        mFullDescriptionLabel.setText(mHero.getDescription());
        return view;
    }

}
