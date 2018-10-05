package com.baulin.alexander.collectionsandmaps.controller;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.model.MapsTest;
import com.baulin.alexander.collectionsandmaps.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.baulin.alexander.collectionsandmaps.model.Constants.*;

public class MapsFragment extends Fragment {

    @BindView(R.id.txtHashMapAdd) TextView hashMapAdd;
    @BindView(R.id.txtHashMapSearch) TextView hashMapSearch;
    @BindView(R.id.txtHashMapRemove) TextView hashMapRemove;

    @BindView(R.id.txtTreeMapAdd) TextView treeMapAdd;
    @BindView(R.id.txtTreeMapSearch) TextView treeMapSearch;
    @BindView(R.id.txtTreeMapRemove) TextView treeMapRemove;

    @BindView(R.id.pbHashMapAdd) ProgressBar pbHashMapAdd;
    @BindView(R.id.pbHashMapSearch) ProgressBar pbHashMapSearch;
    @BindView(R.id.pbHashMapRemove) ProgressBar pbHashMapRemove;

    @BindView(R.id.pbTreeMapAdd) ProgressBar pbTreeMapAdd;
    @BindView(R.id.pbTreeMapSearch) ProgressBar pbTreeMapSearch;
    @BindView(R.id.pbTreeMapRemove) ProgressBar pbTreeMapRemove;

    private Unbinder unbinder;

    int testOperationsCounter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maps, container, false);
        //ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void calculateTimeOperations() {
        new TaskExecutor(hashMapAdd).execute(HASH_MAP_ADD);
        new TaskExecutor(hashMapSearch).execute(HASH_MAP_SEARCH);
        new TaskExecutor(hashMapRemove).execute(HASH_MAP_REMOVE);

        new TaskExecutor(treeMapAdd).execute(TREE_MAP_ADD);
        new TaskExecutor(treeMapSearch).execute(TREE_MAP_SEARCH);
        new TaskExecutor(treeMapRemove).execute(TREE_MAP_REMOVE);
    }

    private class TaskExecutor extends AsyncTask<String, Void, Object[]> {
        private TextView cell;

        TaskExecutor(TextView textView) {
            cell = textView;
        }

        @Override
        protected void onPreExecute() {
            pbHashMapAdd.setVisibility(View.VISIBLE);
            pbHashMapSearch.setVisibility(View.VISIBLE);
            pbHashMapRemove.setVisibility(View.VISIBLE);

            pbTreeMapAdd.setVisibility(View.VISIBLE);
            pbTreeMapSearch.setVisibility(View.VISIBLE);
            pbTreeMapRemove.setVisibility(View.VISIBLE);

            super.onPreExecute();
        }

        @Override
        protected Object[] doInBackground(String... strings) {
            String testName = strings[0];
            Object[] result = new Object[2];

            while (true) {
                if(Main.semaphore.tryAcquire()) {
                    Log.d("myLogs3", "gotAcquire " + testName + " " + ++testOperationsCounter);
                    break;
                }
            }

            switch (testName) {
                case HASH_MAP_ADD:
                    result[0] = MapsTest.addNew(MapsTest.hashMap);
                    result[1] = pbHashMapAdd;
                    break;
                case HASH_MAP_SEARCH:
                    result[0] = MapsTest.searchByKey(MapsTest.hashMap);
                    result[1] = pbHashMapSearch;
                    break;
                case HASH_MAP_REMOVE:
                    result[0] = MapsTest.remove(MapsTest.hashMap);
                    result[1] = pbHashMapRemove;
                    break;
                case TREE_MAP_ADD:
                    result[0] = MapsTest.addNew(MapsTest.treeMap);
                    result[1] = pbTreeMapAdd;
                    break;
                case TREE_MAP_SEARCH:
                    result[0] = MapsTest.searchByKey(MapsTest.treeMap);
                    result[1] = pbTreeMapSearch;
                    break;
                case TREE_MAP_REMOVE:
                    result[0] = MapsTest.remove(MapsTest.treeMap);
                    result[1] = pbTreeMapRemove;
                    break;
            }
            Main.semaphore.release();
            Log.d("myLogs3", "semaphor release");
            return result;
        }

        @Override
        protected void onPostExecute(Object[] result) {
            Long timeTaskExecution = (Long)result[0];
            ProgressBar progressBar = (ProgressBar)result[1];
            if (cell != null) {
                cell.setText(String.valueOf(timeTaskExecution));
            }
            if(progressBar != null) {
                progressBar.setVisibility(View.INVISIBLE);
            }
            Log.d("myLogs", "" + timeTaskExecution);
        }

    }
}
