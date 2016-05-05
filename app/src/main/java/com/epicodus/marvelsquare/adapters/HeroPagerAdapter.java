package com.epicodus.marvelsquare.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.marvelsquare.models.Hero;
import com.epicodus.marvelsquare.ui.HeroDetailFragment;

import java.util.ArrayList;

public class HeroPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Hero> mHeroes;

    public HeroPagerAdapter(FragmentManager fm, ArrayList<Hero> heroes) {
        super(fm);
        mHeroes = heroes;
    }

    @Override
    public Fragment getItem(int position) {
        return HeroDetailFragment.newInstance(mHeroes.get(position));
    }

    @Override
    public int getCount() {
        return mHeroes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mHeroes.get(position).getName();
    }
}
