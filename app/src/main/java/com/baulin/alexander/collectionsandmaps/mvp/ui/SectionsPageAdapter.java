package com.baulin.alexander.collectionsandmaps.mvp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;



class SectionsPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitles = new ArrayList<>();

    SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    void addFragment(Fragment f, String title) {
        fragmentList.add(f);
        fragmentTitles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
