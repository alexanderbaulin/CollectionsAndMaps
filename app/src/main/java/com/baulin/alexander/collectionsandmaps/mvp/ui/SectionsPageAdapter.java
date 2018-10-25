package com.baulin.alexander.collectionsandmaps.mvp.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;



class SectionsPageAdapter extends FragmentPagerAdapter {
    private MainActivity ma;

    SectionsPageAdapter(FragmentManager fm, MainActivity activity) {
        super(fm);
        ma = activity;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Collections";
            case 1:
                return "Maps";
            default:
                return null;
        }

    }

    @Override
    public Fragment getItem(int position) {
        Log.d("test", "getItem " + position);
        switch (position) {
            case 0:
                return new CollectionsFragment();
            case 1:
                return new MapsFragment();
            default:
                return null;
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment createdFragment = (Fragment)super.instantiateItem(container, position);
        Log.d("test", "instantiateItem " + position);
        switch (position) {
            case 0:
                ma.collectionsFragment = (CollectionsFragment) createdFragment;
                break;
            case 1:
                ma.mapsFragment = (MapsFragment) createdFragment;
                break;
        }
        return createdFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
