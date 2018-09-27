package com.baulin.alexander.collectionsandmaps.activities;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.CollectionsTest;
import com.baulin.alexander.collectionsandmaps.MapsTest;
import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.SectionsPageAdapter;
import com.baulin.alexander.collectionsandmaps.fragments.CollectionsFragment;
import com.baulin.alexander.collectionsandmaps.fragments.MapsFragment;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main extends AppCompatActivity {

    private static final String ARRAY_LIST = "arrayList";
    private static final String LINKED_LIST = "linkedList";
    private static final String COPY_ARRAY_LIST = "copyArrayList";
    private static final String HASH_MAP = "hashMap";
    private static final String TREE_MAP = "treeMap";

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.container) ViewPager viewPager;
    @BindView(R.id.btnFloatingAction) FloatingActionButton floatingActionButton;

    CollectionsFragment collectionsFragment;
    MapsFragment mapsFragment;
    SectionsPageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ButterKnife.bind(this);

        mapsFragment = new MapsFragment();
        collectionsFragment = new CollectionsFragment();
        pageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(collectionsFragment, "Collections");
        pageAdapter.addFragment(mapsFragment, "Maps");
        TabLayout tabLayout = findViewById(R.id.tabs);
        viewPager.setAdapter(pageAdapter);

        viewPager.setVisibility(View.INVISIBLE);
        progressBar.setProgress(0);
        progressBar.setMax(CollectionsTest.numberOfElements);
        tabLayout.setupWithViewPager(viewPager);

        Log.d("myLogs", "onCreate");

        new CollectionFillTask().execute(ARRAY_LIST);
        new CollectionFillTask().execute(LINKED_LIST);
        new CollectionFillTask().execute(COPY_ARRAY_LIST);
        new CollectionFillTask().execute(HASH_MAP);
        new CollectionFillTask().execute(TREE_MAP);
    }

    @OnClick(R.id.btnFloatingAction)
    public void onClickFloatingActionButton(View view) {
        collectionsFragment.calculateTimeOperations();
        mapsFragment.calculateTimeOperations();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        progressBar.setProgress(0);
        Log.d("myLogs", "restore");
        super.onRestoreInstanceState(savedInstanceState);
    }

    private class CollectionFillTask extends AsyncTask<String, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            String task = strings[0];
            switch (task) {
                case ARRAY_LIST:
                    CollectionsTest.fillWithElements(CollectionsTest.arrayList);
                    break;
                case LINKED_LIST:
                    CollectionsTest.fillWithElements(CollectionsTest.linkedList);
                    break;
                case COPY_ARRAY_LIST: {
                    CollectionsTest.fillWithElements(CollectionsTest.copyOnWriteArrayList);
                    return true;
                }
                case HASH_MAP:
                    MapsTest.fillWithElements(MapsTest.hashMap);
                    break;
                case TREE_MAP:
                    MapsTest.fillWithElements(MapsTest.treeMap);
                    break;
            }
            return false;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result) {
                progressBar.setVisibility(View.GONE);
                viewPager.setVisibility(View.VISIBLE);
                floatingActionButton.setVisibility(View.VISIBLE);
            }
        }
    }
}
