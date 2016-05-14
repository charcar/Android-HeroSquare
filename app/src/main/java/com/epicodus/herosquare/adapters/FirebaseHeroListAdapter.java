package com.epicodus.herosquare.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.herosquare.R;
import com.epicodus.herosquare.models.Hero;
import com.epicodus.herosquare.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

public class FirebaseHeroListAdapter extends FirebaseRecyclerAdapter<HeroViewHolder, Hero>{

    public FirebaseHeroListAdapter(Query query, Class<Hero> itemClass) {
        super(query, itemClass);
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hero_list_item, parent, false);
        return new HeroViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        holder.bindHero(getItem(position));
    }

    @Override
    protected void itemAdded(Hero item, String key, int position) {

    }

    @Override
    protected void itemChanged(Hero oldItem, Hero newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Hero item, String key, int position) {

    }

    @Override
    protected void itemMoved(Hero item, String key, int oldPosition, int newPosition) {

    }
}

