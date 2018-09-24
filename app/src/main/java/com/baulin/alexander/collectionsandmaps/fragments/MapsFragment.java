package com.baulin.alexander.collectionsandmaps.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.CollectionsTest;
import com.baulin.alexander.collectionsandmaps.MapsTest;
import com.baulin.alexander.collectionsandmaps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapsFragment extends Fragment {

    @BindView(R.id.txtHashMapAdd) TextView hashMapAdd;
    @BindView(R.id.txtHashMapSearch) TextView hashMapSearch;
    @BindView(R.id.txtHashMapRemove) TextView hashMapRemove;

    @BindView(R.id.txtTreeMapAdd) TextView treeMapAdd;
    @BindView(R.id.txtTreeMapSearch) TextView treeMapSearch;
    @BindView(R.id.txtTreeMapRemove) TextView treeMapRemove;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maps, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void calculateTimeOperations() {
        new TaskExecutor(hashMapAdd).execute(MapsTest.HASH_MAP_ADD);
        new TaskExecutor(hashMapSearch).execute(MapsTest.HASH_MAP_SEARCH);
        new TaskExecutor(hashMapRemove).execute(MapsTest.HASH_MAP_REMOVE);

        new TaskExecutor(treeMapAdd).execute(MapsTest.TREE_MAP_ADD);
        new TaskExecutor(treeMapSearch).execute(MapsTest.TREE_MAP_SEARCH);
        new TaskExecutor(treeMapRemove).execute(MapsTest.TREE_MAP_REMOVE);
    }

    private class TaskExecutor extends AsyncTask<String, Void, Long> {
        private TextView cell;

        TaskExecutor(TextView textView) {
            cell = textView;
        }

        @Override
        protected Long doInBackground(String... strings) {
            String testName = strings[0];
            Long timeTaskExecution = 0L;
            switch (testName) {
                case MapsTest.HASH_MAP_ADD:
                    timeTaskExecution = MapsTest.addNew(MapsTest.hashMap);
                    break;
                case MapsTest.HASH_MAP_SEARCH:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.arrayList);
                    break;
                case MapsTest.HASH_MAP_REMOVE:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.arrayList);
                    break;
                case MapsTest.TREE_MAP_ADD:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                    break;
                case MapsTest.TREE_MAP_SEARCH:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                    break;
                case MapsTest.TREE_MAP_REMOVE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                    break;
            }
            return timeTaskExecution;
        }

        @Override
        protected void onPostExecute(Long timeTaskExecution) {
            if (cell != null) {
                cell.setText(String.valueOf(timeTaskExecution));
            }
            Log.d("myLogs", "" + timeTaskExecution);
        }

    }
}
