package com.baulin.alexander.collectionsandmaps.mvp.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


public class SectionsPageAdapter extends FragmentPagerAdapter {
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
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment createdFragment = (Fragment)super.instantiateItem(container, position);
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

    MapsFragment getMapFragment() {
        return maps;
    }

    CollectionsFragment getCollectionFragment() {
        return collections;
    }
}
