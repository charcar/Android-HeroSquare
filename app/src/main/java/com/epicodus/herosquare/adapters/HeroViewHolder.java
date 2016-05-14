package com.epicodus.herosquare.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.herosquare.R;
import com.epicodus.herosquare.models.Hero;
import com.epicodus.herosquare.ui.HeroDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HeroViewHolder extends RecyclerView.ViewHolder {
    private static final int MAX_WIDTH = 150;
    private static final int MAX_HEIGHT = 150;

    @Bind(R.id.heroThumbImageView) ImageView mHeroThumbImageView;
    @Bind(R.id.heroNameTextView) TextView mHeroNameTextView;
    @Bind(R.id.realNameTextView) TextView mRealNameTextView;
    @Bind(R.id.originTextView) TextView mOriginTextView;

    private Context mContext;
    private ArrayList<Hero> mHeroes = new ArrayList<>();


    public HeroViewHolder(View itemView, ArrayList<Hero> heroes) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mHeroes = heroes;
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, HeroDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("heroes", Parcels.wrap(mHeroes));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindHero(Hero hero) {
        Picasso.with(mContext)
                .load(hero.getIconImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mHeroThumbImageView);

        mHeroNameTextView.setText(hero.getName());
        mRealNameTextView.setText(hero.getRealName());
        mOriginTextView.setText(hero.getOrigin());
    }
}

