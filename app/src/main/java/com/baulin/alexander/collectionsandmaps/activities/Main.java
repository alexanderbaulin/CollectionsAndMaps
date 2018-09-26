package com.baulin.alexander.collectionsandmaps.activities;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class Main extends AppCompatActivity {

    private static final String ARRAY_LIST = "arrayList";
    private static final String LINKED_LIST = "linkedList";
    private static final String COPY_ARRAY_LIST = "copyArrayList";
    private static final String HASH_MAP = "hashMap";
    private static final String TREE_MAP = "treeMap";
    SectionsPageAdapter pageAdapter;

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.container) ViewPager viewPager;
    @BindView(R.id.btnFloatingAction) FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewPager = findViewById(R.id.container);
        progressBar = findViewById(R.id.progressBar);
        floatingActionButton = findViewById(R.id.btnFloatingAction);

        viewPager.setVisibility(View.INVISIBLE);
        TabLayout tabLayout = findViewById(R.id.tabs);
        progressBar.setProgress(0);
        progressBar.setMax(CollectionsTest.numberOfElements);
        pageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new CollectionsFragment(), "Collections");
        pageAdapter.addFragment(new MapsFragment(), "Maps");
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        Log.d("myLogs", "onCreate");
        new CollectionFillTask().execute(ARRAY_LIST);
        new CollectionFillTask().execute(LINKED_LIST);
        new CollectionFillTask().execute(COPY_ARRAY_LIST);
        new CollectionFillTask().execute(HASH_MAP);
        new CollectionFillTask().execute(TREE_MAP);
    }

    public void onClickFloatingActionButton(View view) {
        CollectionsFragment c = (CollectionsFragment)pageAdapter.getItem(0);
        c.calculateTimeOperations();
        MapsFragment m = (MapsFragment)pageAdapter.getItem(1);
        m.calculateTimeOperations();
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
                    for (int i = 0; i < CollectionsTest.numberOfElements; i++) {
                        if(CollectionsTest.copyOnWriteArrayList.getClass().toString().equals("class java.util.concurrent.CopyOnWriteArrayList"))  Log.d("myLogs", CollectionsTest.copyOnWriteArrayList.getClass()  + "add element " + i);
                        CollectionsTest.copyOnWriteArrayList.add(i);
                        onProgressUpdate(CollectionsTest.copyOnWriteArrayList.size());
                    }
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
           // Log.d("myLogs","value = " + values[0]);
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
