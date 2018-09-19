package com.baulin.alexander.collectionsandmaps.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.SectionsPageAdapter;
import com.baulin.alexander.collectionsandmaps.fragments.CollectionsFragment;
import com.baulin.alexander.collectionsandmaps.fragments.MapsFragment;

public class Main extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewPager viewPager = findViewById(R.id.container);
        TabLayout tabLayout = findViewById(R.id.tabs);
        SectionsPageAdapter pageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new CollectionsFragment(), "Collections");
        pageAdapter.addFragment(new MapsFragment(), "Maps");
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        CollectionsFragment c = (CollectionsFragment)pageAdapter.getItem(0);
        c.calculateTimeOperations();
        MapsFragment m = (MapsFragment)pageAdapter.getItem(1);
        m.calculateTimeOperations();

    }
}
