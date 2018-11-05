package com.baulin.alexander.collectionsandmaps.mvp.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


class SectionsPageAdapter extends FragmentPagerAdapter {
    private CollectionsFragment collections;
    private MapsFragment maps;

    SectionsPageAdapter(FragmentManager fm) {
        super(fm);
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
                collections = (CollectionsFragment) createdFragment;
                break;
            case 1:
                maps = (MapsFragment) createdFragment;
                break;
        }
        return createdFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    ProgressBar getProgressBar(int id) {
        ProgressBar view = maps.getProgressBar(id);
        if(view != null)
            return view;
        else
            return collections.getProgressBar(id);
    }

    TextView getTextView(int id) {
        TextView view = maps.getTextView(id);
        if(view != null)
            return view;
        else
            return collections.getTextView(id);
    }

    void setCollectionProgressBarsVisible() {
        collections.setProgressBarsVisible();
    }

    void setMapsProgressBarsVisible() {
        maps.setProgressBarsVisible();
    }
}
