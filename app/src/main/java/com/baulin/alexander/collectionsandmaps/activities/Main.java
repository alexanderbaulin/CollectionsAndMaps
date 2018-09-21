package com.baulin.alexander.collectionsandmaps.activities;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.baulin.alexander.collectionsandmaps.CollectionsTest;
import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.SectionsPageAdapter;
import com.baulin.alexander.collectionsandmaps.fragments.CollectionsFragment;
import com.baulin.alexander.collectionsandmaps.fragments.MapsFragment;

public class Main extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private static final String ARRAY_LIST = "arrayList";
    private static final String LINKED_LIST = "linkedList";
    private static final String COPY_ARRAY_LIST = "copyArrayList";
    SectionsPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewPager viewPager = findViewById(R.id.container);
        TabLayout tabLayout = findViewById(R.id.tabs);
        pageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new CollectionsFragment(), "Collections");
        pageAdapter.addFragment(new MapsFragment(), "Maps");
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        new CollectionFillTask().execute(ARRAY_LIST);
        new CollectionFillTask().execute(LINKED_LIST);
        new CollectionFillTask().execute(COPY_ARRAY_LIST);
    }

    public void onClickFloatingActionButton(View view) {
        CollectionsFragment c = (CollectionsFragment)pageAdapter.getItem(0);
        c.calculateTimeOperations();
        MapsFragment m = (MapsFragment)pageAdapter.getItem(1);
        m.calculateTimeOperations();
    }

    private class CollectionFillTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            String task = strings[0];
            switch (task) {
                case ARRAY_LIST:
                    CollectionsTest.fillWithElements(CollectionsTest.arrayList);
                    break;
                case LINKED_LIST:
                    CollectionsTest.fillWithElements(CollectionsTest.linkedList);
                    break;
                case COPY_ARRAY_LIST:
                    CollectionsTest.fillWithElements(CollectionsTest.copyOnWriteArrayList);
                    break;
            }
            return null;
        }
    }
}
