package com.epicodus.herosquare.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class HeroListAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private ArrayList<Hero> mHeroes = new ArrayList<>();
    private Context mContext;

    public HeroListAdapter(Context context, ArrayList<Hero> heroes) {
        mContext = context;
        mHeroes = heroes;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_list_item, parent, false);
        HeroViewHolder viewHolder = new HeroViewHolder(view, mHeroes);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        holder.bindHero(mHeroes.get(position));
    }

    @Override
    public int getItemCount() {
        return mHeroes.size();
    }


}
