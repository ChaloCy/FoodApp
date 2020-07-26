package com.inducesmile.androidfoodordering.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.inducesmile.androidfoodordering.Fragment.DealsFragment;

public class SlideshowPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = SlideshowPagerAdapter.class.getSimpleName();

    private static final int DEAL_NUMBER = 4;


    public SlideshowPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new DealsFragment();
    }

    @Override
    public int getCount() {
        return DEAL_NUMBER;
    }
}
