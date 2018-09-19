package com.baulin.alexander.collectionsandmaps.fragments;


import android.arch.core.executor.TaskExecutor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.baulin.alexander.collectionsandmaps.Collections;
import com.baulin.alexander.collectionsandmaps.R;

import java.lang.ref.WeakReference;

public class CollectionsFragment extends Fragment {

    Collections collections = new Collections();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collections, container, false);
        return view;
    }

    public void calculateTimeOperations() {
        new TaskExecutor(view.findViewById(R.id.tabs)).execute(Collections.ARRAY_LIST_ADD_IN_THE_BEGIN);
        //Log.d("myLogs", "arrayListAddInTheBegin = " + collections.arrayListAddInTheBegin()) ;
        Log.d("myLogs", "arrayListAddInTheEnd = " + collections.arrayListAddInTheEnd());


    }

    private static class TaskExecutor extends AsyncTask<String, Void, Long> {
        private View v;

        TaskExecutor(View cell) {
            v = cell;
        }

        @Override
        protected Long doInBackground(String... strings) {
            String testName = strings[0];
            Long timeTaskExecution = 0L;
            switch (testName) {
                case Collections.ARRAY_LIST_ADD_IN_THE_BEGIN:
                    timeTaskExecution = collections.arrayListAddInTheBegin();
                    break;
                case Collections.ARRAY_LIST_ADD_IN_THE_END:
                    timeTaskExecution = collections.arrayListAddInTheEnd();
                    break;
            }
            return timeTaskExecution;
        }

        @Override
        protected void onPostExecute(Long timeTaskExecution) {
            Log.d("myLogs", "" + timeTaskExecution);

        }

    }
}
