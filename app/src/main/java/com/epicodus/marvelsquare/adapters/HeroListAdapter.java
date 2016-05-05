package com.epicodus.marvelsquare.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.marvelsquare.R;
import com.epicodus.marvelsquare.models.Hero;
import com.epicodus.marvelsquare.ui.HeroDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroViewHolder> {
    private static final int MAX_WIDTH = 150;
    private static final int MAX_HEIGHT = 150;

    private ArrayList<Hero> mHeroes = new ArrayList<>();
    private Context mContext;

    public HeroListAdapter(Context context, ArrayList<Hero> heroes) {
        mContext = context;
        mHeroes = heroes;
    }

    @Override
    public HeroListAdapter.HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_list_item, parent, false);
        HeroViewHolder viewHolder = new HeroViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HeroListAdapter.HeroViewHolder holder, int position) {
        holder.bindHero(mHeroes.get(position));
    }

    @Override
    public int getItemCount() {
        return mHeroes.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.heroThumbImageView) ImageView mHeroThumbImageView;
        @Bind(R.id.heroNameTextView) TextView mHeroNameTextView;
        @Bind(R.id.realNameTextView) TextView mRealNameTextView;
        @Bind(R.id.originTextView) TextView mOriginTextView;
        private Context mContext;

        public HeroViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
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
}
