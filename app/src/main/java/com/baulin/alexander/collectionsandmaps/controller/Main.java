package com.baulin.alexander.collectionsandmaps.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.baulin.alexander.collectionsandmaps.model.CollectionsTest;
import com.baulin.alexander.collectionsandmaps.model.MapsTest;
import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.view.MainView;

import java.util.concurrent.Semaphore;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.baulin.alexander.collectionsandmaps.model.Constants.*;


public class Main extends AppCompatActivity {


    CollectionsFragment collectionsFragment;
    MapsFragment mapsFragment;
    SectionsPageAdapter pageAdapter;
    MainView mainView;
    public static Semaphore semaphore;
    public static int numberOfElements;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("myLogs", "onCreate");

        ButterKnife.bind(this);

        int processorsNumber = Runtime.getRuntime().availableProcessors();
        semaphore = new Semaphore(processorsNumber, true);
        mapsFragment = new MapsFragment();
        collectionsFragment = new CollectionsFragment();
        pageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mainView = new MainView(this);
        pageAdapter.addFragment(collectionsFragment, "Collections");
        pageAdapter.addFragment(mapsFragment, "Maps");
        mainView.setPageAdapter(pageAdapter);
    }

    @OnClick(R.id.btnSubmit)
    public void onClickSubmitButton(View view) {
        if(mainView.submitButtonClicked()) {
            new CollectionFillTask().execute(ARRAY_LIST);
            new CollectionFillTask().execute(LINKED_LIST);
            new CollectionFillTask().execute(COPY_ARRAY_LIST);
            new CollectionFillTask().execute(HASH_MAP);
            new CollectionFillTask().execute(TREE_MAP);
        }
    }

    @OnClick(R.id.btnFloatingAction)
    public void onClickFloatingActionButton(View view) {
        if(mainView.isTabCollectionSelected()) {
            collectionsFragment.calculateTimeOperations();
        } else
            mapsFragment.calculateTimeOperations();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
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
            //progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result) {
                mainView.setPostExecuteUI();
            }
        }
    }
}
