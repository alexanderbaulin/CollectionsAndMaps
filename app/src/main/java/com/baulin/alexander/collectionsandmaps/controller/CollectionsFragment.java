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


import com.baulin.alexander.collectionsandmaps.model.CollectionsTest;
import com.baulin.alexander.collectionsandmaps.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.baulin.alexander.collectionsandmaps.model.Constants.*;

public class CollectionsFragment extends Fragment {

    @BindView(R.id.txtArrayAddBegin) TextView arrayAddBegin;
    @BindView(R.id.txtArrayAddMiddle) TextView arrayAddMiddle;
    @BindView(R.id.txtArrayAddEnd) TextView arrayAddEnd;
    @BindView(R.id.txtArraySearchValue) TextView arraySearchValue;
    @BindView(R.id.txtArrayRemoveBegin) TextView arrayRemoveBegin;
    @BindView(R.id.txtArrayRemoveMiddle) TextView arrayRemoveMiddle;
    @BindView(R.id.txtArrayRemoveEnd) TextView arrayRemoveEnd;

    @BindView(R.id.txtLinkedAddBegin) TextView linkedAddBegin;
    @BindView(R.id.txtLinkedAddMiddle) TextView linkedAddMiddle;
    @BindView(R.id.txtLinkedAddEnd) TextView linkedAddEnd;
    @BindView(R.id.txtLinkedSearchValue) TextView linkedSearchValue;
    @BindView(R.id.txtLinkedRemoveBegin) TextView linkedRemoveBegin;
    @BindView(R.id.txtLinkedRemoveMiddle) TextView linkedRemoveMiddle;
    @BindView(R.id.txtLinkedRemoveEnd) TextView linkedRemoveEnd;

    @BindView(R.id.txtCopyOnWriteAddBegin) TextView copyOnWriteAddBegin;
    @BindView(R.id.txtCopyOnWriteAddMiddle) TextView copyOnWriteAddMiddle;
    @BindView(R.id.txtCopyOnWriteAddEnd) TextView copyOnWriteAddEnd;
    @BindView(R.id.txtCopyOnWriteSearchValue) TextView copyOnWriteSearchValue;
    @BindView(R.id.txtCopyOnWriteRemoveBegin) TextView copyOnWriteRemoveBegin;
    @BindView(R.id.txtCopyOnWriteRemoveMiddle) TextView copyOnWriteRemoveMiddle;
    @BindView(R.id.txtCopyOnWriteRemoveEnd) TextView copyOnWriteRemoveEnd;

    @BindView(R.id.pbArrayAddBegin) ProgressBar pbArrayAddBegin;
    @BindView(R.id.pbArrayAddMiddle) ProgressBar pbArrayAddMiddle;
    @BindView(R.id.pbArrayAddEnd) ProgressBar pbArrayAddEnd;
    @BindView(R.id.pbArraySearchValue) ProgressBar pbArraySearchValue;
    @BindView(R.id.pbArrayRemoveBegin) ProgressBar pbArrayRemoveBegin;
    @BindView(R.id.pbArrayRemoveMiddle) ProgressBar pbArrayRemoveMiddle;
    @BindView(R.id.pbArrayRemoveEnd) ProgressBar pbArrayRemoveEnd;

    @BindView(R.id.pbLinkedAddBegin) ProgressBar pbLinkedAddBegin;
    @BindView(R.id.pbLinkedAddMiddle) ProgressBar pbLinkedAddMiddle;
    @BindView(R.id.pbLinkedAddEnd) ProgressBar pbLinkedAddEnd;
    @BindView(R.id.pbLinkedSearchValue) ProgressBar pbLinkedSearchValue;
    @BindView(R.id.pbLinkedRemoveBegin) ProgressBar pbLinkedRemoveBegin;
    @BindView(R.id.pbLinkedRemoveMiddle) ProgressBar pbLinkedRemoveMiddle;
    @BindView(R.id.pbLinkedRemoveEnd) ProgressBar pbLinkedRemoveEnd;

    @BindView(R.id.pbCopyOnWriteAddBegin) ProgressBar pbCopyOnWriteAddBegin;
    @BindView(R.id.pbCopyOnWriteAddMiddle) ProgressBar pbCopyOnWriteAddMiddle;
    @BindView(R.id.pbCopyOnWriteAddEnd) ProgressBar pbCopyOnWriteAddEnd;
    @BindView(R.id.pbCopyOnWriteSearchValue) ProgressBar pbCopyOnWriteSearchValue;
    @BindView(R.id.pbCopyOnWriteRemoveBegin) ProgressBar pbCopyOnWriteRemoveBegin;
    @BindView(R.id.pbCopyOnWriteRemoveMiddle) ProgressBar pbCopyOnWriteRemoveMiddle;
    @BindView(R.id.pbCopyOnWriteRemoveEnd) ProgressBar pbCopyOnWriteRemoveEnd;

    private Unbinder unbinder;


    int testOperationsCounter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collections, container, false);
        //ButterKnife.bind(this, view);
        Log.d("myLogs6", "onCreateView");
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        Log.d("myLogs6", "onDestroyView");
        unbinder.unbind();
    }

    public void calculateTimeOperations() {
        new TaskExecutor(arrayAddBegin).execute(ARRAY_ADD_BEGIN);
        new TaskExecutor(arrayAddMiddle).execute(ARRAY_ADD_MIDDLE);
        new TaskExecutor(arrayAddEnd).execute(ARRAY_ADD_END);
        new TaskExecutor(arraySearchValue).execute(ARRAY_SEARCH_VALUE);
        new TaskExecutor(arrayRemoveBegin).execute(ARRAY_REMOVE_BEGIN);
        new TaskExecutor(arrayRemoveMiddle).execute(ARRAY_REMOVE_MIDDLE);
        new TaskExecutor(arrayRemoveEnd).execute(ARRAY_REMOVE_END);

        new TaskExecutor(linkedAddBegin).execute(LINKED_ADD_BEGIN);
        new TaskExecutor(linkedAddMiddle).execute(LINKED_ADD_MIDDLE);
        new TaskExecutor(linkedAddEnd).execute(LINKED_ADD_END);
        new TaskExecutor(linkedSearchValue).execute(LINKED_SEARCH_VALUE);
        new TaskExecutor(linkedRemoveBegin).execute(LINKED_REMOVE_BEGIN);
        new TaskExecutor(linkedRemoveMiddle).execute(LINKED_REMOVE_MIDDLE);
        new TaskExecutor(linkedRemoveEnd).execute(LINKED_REMOVE_END);

        new TaskExecutor(copyOnWriteAddBegin).execute(COPY_ON_WRITE_BEGIN);
        new TaskExecutor(copyOnWriteAddMiddle).execute(COPY_ON_WRITE_ADD_MIDDLE);
        new TaskExecutor(copyOnWriteAddEnd).execute(COPY_ON_WRITE_ADD_END);
        new TaskExecutor(copyOnWriteSearchValue).execute(COPY_ON_WRITE_SEARCH_VALUE);
        new TaskExecutor(copyOnWriteRemoveBegin).execute(COPY_ON_WRITE_REMOVE_BEGIN);
        new TaskExecutor(copyOnWriteRemoveMiddle).execute(COPY_ON_WRITE_REMOVE_MIDDLE);
        new TaskExecutor(copyOnWriteRemoveEnd).execute(COPY_ON_WRITE_REMOVE_END);

    }

    private class TaskExecutor extends AsyncTask<String, Void, Object[]> {
        private TextView cell;

        TaskExecutor(TextView textView) {
            cell = textView;
        }

        @Override
        protected void onPreExecute() {
            if(pbArrayAddBegin == null) return;
            pbArrayAddBegin.setVisibility(View.VISIBLE);
            pbArrayAddMiddle.setVisibility(View.VISIBLE);
            pbArrayAddEnd.setVisibility(View.VISIBLE);
            pbArraySearchValue.setVisibility(View.VISIBLE);
            pbArrayRemoveBegin.setVisibility(View.VISIBLE);
            pbArrayRemoveMiddle.setVisibility(View.VISIBLE);
            pbArrayRemoveEnd.setVisibility(View.VISIBLE);

            pbLinkedAddBegin.setVisibility(View.VISIBLE);
            pbLinkedAddMiddle.setVisibility(View.VISIBLE);
            pbLinkedAddEnd.setVisibility(View.VISIBLE);
            pbLinkedSearchValue.setVisibility(View.VISIBLE);
            pbLinkedRemoveBegin.setVisibility(View.VISIBLE);
            pbLinkedRemoveMiddle.setVisibility(View.VISIBLE);
            pbLinkedRemoveEnd.setVisibility(View.VISIBLE);

            pbCopyOnWriteAddBegin.setVisibility(View.VISIBLE);
            pbCopyOnWriteAddMiddle.setVisibility(View.VISIBLE);
            pbCopyOnWriteAddEnd.setVisibility(View.VISIBLE);
            pbCopyOnWriteSearchValue.setVisibility(View.VISIBLE);
            pbCopyOnWriteRemoveBegin.setVisibility(View.VISIBLE);
            pbCopyOnWriteRemoveMiddle.setVisibility(View.VISIBLE);
            pbCopyOnWriteRemoveEnd.setVisibility(View.VISIBLE);

            super.onPreExecute();
        }

        @Override
        protected Object[] doInBackground(String... strings) {
            String testName = strings[0];
            Object[] result = new Object[2];

            while (true) {
                if(Main.semaphore.tryAcquire()) {
                    Log.d("myLogs2", "gotAcquire " + testName + " " + ++testOperationsCounter);
                    break;
                }
            }

            switch (testName) {
                case ARRAY_ADD_BEGIN:
                    result[0] = CollectionsTest.addInTheBegin(CollectionsTest.arrayList);
                    result[1] = pbArrayAddBegin;
                    break;
                case ARRAY_ADD_MIDDLE:
                    result[0] = CollectionsTest.addInTheMiddle(CollectionsTest.arrayList);
                    result[1] = pbArrayAddMiddle;
                    break;
                case ARRAY_ADD_END:
                    result[0] = CollectionsTest.addInTheEnd(CollectionsTest.arrayList);
                    result[1] = pbArrayAddEnd;
                    break;
                case ARRAY_SEARCH_VALUE:
                    result[0] = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                    result[1] = pbArraySearchValue;
                    break;
                case ARRAY_REMOVE_BEGIN:
                    result[0] = CollectionsTest.removeInTheBegin(CollectionsTest.arrayList);
                    result[1] = pbArrayRemoveBegin;
                    break;
                case ARRAY_REMOVE_MIDDLE:
                    result[0] = CollectionsTest.removeInTheMiddle(CollectionsTest.arrayList);
                    result[1] = pbArrayRemoveMiddle;
                    break;
                case ARRAY_REMOVE_END:
                    result[0] = CollectionsTest.removeInTheEnd(CollectionsTest.arrayList);
                    result[1] = pbArrayRemoveEnd;
                    break;

                case LINKED_ADD_BEGIN:
                    result[0] = CollectionsTest.addInTheBegin(CollectionsTest.linkedList);
                    result[1] = pbLinkedAddBegin;
                    break;
                case LINKED_ADD_MIDDLE:
                    result[0] = CollectionsTest.addInTheMiddle(CollectionsTest.linkedList);
                    result[1] = pbLinkedAddMiddle;
                    break;
                case LINKED_ADD_END:
                    result[0] = CollectionsTest.addInTheEnd(CollectionsTest.linkedList);
                    result[1] = pbLinkedAddEnd;
                    break;
                case LINKED_SEARCH_VALUE:
                    result[0] = CollectionsTest.searchByValue(CollectionsTest.linkedList);
                    result[1] = pbLinkedSearchValue;
                    break;
                case LINKED_REMOVE_BEGIN:
                    result[0] = CollectionsTest.removeInTheBegin(CollectionsTest.linkedList);
                    result[1] = pbLinkedRemoveBegin;
                    break;
                case LINKED_REMOVE_MIDDLE:
                    result[0] = CollectionsTest.removeInTheMiddle(CollectionsTest.linkedList);
                    result[1] = pbLinkedRemoveMiddle;
                    break;
                case LINKED_REMOVE_END:
                    result[0] = CollectionsTest.removeInTheEnd(CollectionsTest.linkedList);
                    result[1] = pbLinkedRemoveEnd;
                    break;

                case COPY_ON_WRITE_BEGIN:
                    result[0] = CollectionsTest.addInTheBegin(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteAddBegin;
                    break;
                case COPY_ON_WRITE_ADD_MIDDLE:
                    result[0] = CollectionsTest.addInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteAddMiddle;
                    break;
                case COPY_ON_WRITE_ADD_END:
                    result[0] = CollectionsTest.addInTheEnd(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteAddEnd;
                    break;
                case COPY_ON_WRITE_SEARCH_VALUE:
                    result[0] = CollectionsTest.searchByValue(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteSearchValue;
                    break;
                case COPY_ON_WRITE_REMOVE_BEGIN:
                    result[0] = CollectionsTest.removeInTheBegin(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteRemoveBegin;
                    break;
                case COPY_ON_WRITE_REMOVE_MIDDLE:
                    result[0] = CollectionsTest.removeInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteRemoveMiddle;
                    break;
                case COPY_ON_WRITE_REMOVE_END:
                    result[0] = CollectionsTest.removeInTheEnd(CollectionsTest.copyOnWriteArrayList);
                    result[1] = pbCopyOnWriteRemoveEnd;
                    break;
            }
            Main.semaphore.release();
            Log.d("myLogs2", "semaphor release");
            return result;
        }

        @Override
        protected void onPostExecute(Object[] result) {
            Long timeTaskExecution = (Long)result[0];
            ProgressBar progressBar = (ProgressBar)result[1];
            if (cell != null) {
                cell.setText(String.valueOf(timeTaskExecution));
            } else Log.d("myLogs6", "cell = null");
            if(progressBar != null) {
                progressBar.setVisibility(View.INVISIBLE);
            }
            Log.d("myLogs", "" + timeTaskExecution);
        }
    }
}
