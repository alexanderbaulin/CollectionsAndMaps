package com.baulin.alexander.collectionsandmaps.presenter;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.interfaces.View;
import com.baulin.alexander.collectionsandmaps.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.model.CollectionsTest;
import com.baulin.alexander.collectionsandmaps.model.MapsTest;
import com.baulin.alexander.collectionsandmaps.R;

import java.util.concurrent.Semaphore;

import static android.view.View.*;
import static com.baulin.alexander.collectionsandmaps.model.Constants.*;

public class Presenter implements com.baulin.alexander.collectionsandmaps.interfaces.Presenter {
    private View view;
    private Model model;
    private Semaphore semaphore;

    public Presenter(View mainView) {
        view = mainView;
        model = new CollectionsAndMapsTests();
        int processorsNumber = Runtime.getRuntime().availableProcessors();
        semaphore = new Semaphore(processorsNumber, true);
    }

    @Override
    public void onSubmitButtonClicked() {
        String number = view.getInputNumber();
        if(number.equals("")) {
            view.showToast("Enter number");
            return;
        }
        model.setNumberOfElement(Integer.valueOf(number));
        Log.d("myLogs5", "button " + Integer.valueOf(number));
        view.setPostSubmitClickedUI();
        fillCollectionsAndMaps();
    }

    @Override
    public void onFloatingCalculationButtonClicked() {
        if(view.isTabCollectionSelected()) {
            testCollections();
        } else {
            testMaps();
        }
    }

    private void fillCollectionsAndMaps() {
        new CollectionFillTask().execute(ARRAY_LIST);
        new CollectionFillTask().execute(LINKED_LIST);
        new CollectionFillTask().execute(COPY_ARRAY_LIST);
        new CollectionFillTask().execute(HASH_MAP);
        new CollectionFillTask().execute(TREE_MAP);
    }

    private void testMaps() {
        new TaskExecutor(view.getTextView(R.id.txtHashMapAdd), view.getProgressBar(R.id.pbHashMapAdd)).execute(HASH_MAP_ADD);
        new TaskExecutor(view.getTextView(R.id.txtHashMapSearch), view.getProgressBar(R.id.pbHashMapSearch)).execute(HASH_MAP_SEARCH);
        new TaskExecutor(view.getTextView(R.id.txtHashMapRemove), view.getProgressBar(R.id.pbHashMapRemove)).execute(HASH_MAP_REMOVE);

        new TaskExecutor(view.getTextView(R.id.txtTreeMapAdd), view.getProgressBar(R.id.pbTreeMapAdd)).execute(TREE_MAP_ADD);
        new TaskExecutor(view.getTextView(R.id.txtTreeMapSearch), view.getProgressBar(R.id.pbTreeMapSearch)).execute(TREE_MAP_SEARCH);
        new TaskExecutor(view.getTextView(R.id.txtTreeMapRemove), view.getProgressBar(R.id.pbTreeMapRemove)).execute(TREE_MAP_REMOVE);
    }

    private void testCollections() {
        new TaskExecutor(view.getTextView(R.id.txtArrayAddBegin), view.getProgressBar(R.id.pbArrayAddBegin)).execute(ARRAY_ADD_BEGIN);
        new TaskExecutor(view.getTextView(R.id.txtArrayAddMiddle), view.getProgressBar(R.id.pbArrayAddMiddle)).execute(ARRAY_ADD_MIDDLE);
        new TaskExecutor(view.getTextView(R.id.txtArrayAddEnd), view.getProgressBar(R.id.pbArrayAddEnd)).execute(ARRAY_ADD_END);
        new TaskExecutor(view.getTextView(R.id.txtArraySearchValue), view.getProgressBar(R.id.pbArraySearchValue)).execute(ARRAY_SEARCH_VALUE);
        new TaskExecutor(view.getTextView(R.id.txtArrayRemoveBegin), view.getProgressBar(R.id.pbArrayRemoveBegin)).execute(ARRAY_REMOVE_BEGIN);
        new TaskExecutor(view.getTextView(R.id.txtArrayRemoveMiddle), view.getProgressBar(R.id.pbArrayRemoveMiddle)).execute(ARRAY_REMOVE_MIDDLE);
        new TaskExecutor(view.getTextView(R.id.txtArrayRemoveEnd), view.getProgressBar(R.id.pbArrayRemoveEnd)).execute(ARRAY_REMOVE_END);

        new TaskExecutor(view.getTextView(R.id.txtLinkedAddBegin), view.getProgressBar(R.id.pbLinkedAddBegin)).execute(LINKED_ADD_BEGIN);
        new TaskExecutor(view.getTextView(R.id.txtLinkedAddMiddle), view.getProgressBar(R.id.pbLinkedAddMiddle)).execute(LINKED_ADD_MIDDLE);
        new TaskExecutor(view.getTextView(R.id.txtLinkedAddEnd), view.getProgressBar(R.id.pbLinkedAddEnd)).execute(LINKED_ADD_END);
        new TaskExecutor(view.getTextView(R.id.txtLinkedSearchValue), view.getProgressBar(R.id.pbLinkedSearchValue)).execute(LINKED_SEARCH_VALUE);
        new TaskExecutor(view.getTextView(R.id.txtLinkedRemoveBegin), view.getProgressBar(R.id.pbLinkedRemoveBegin)).execute(LINKED_REMOVE_BEGIN);
        new TaskExecutor(view.getTextView(R.id.txtLinkedRemoveMiddle), view.getProgressBar(R.id.pbLinkedRemoveMiddle)).execute(LINKED_REMOVE_MIDDLE);
        new TaskExecutor(view.getTextView(R.id.txtLinkedRemoveEnd), view.getProgressBar(R.id.pbLinkedRemoveEnd)).execute(LINKED_REMOVE_END);

        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteAddBegin), view.getProgressBar(R.id.pbCopyOnWriteAddBegin)).execute(COPY_ON_WRITE_BEGIN);
        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteAddMiddle), view.getProgressBar(R.id.pbCopyOnWriteAddMiddle)).execute(COPY_ON_WRITE_ADD_MIDDLE);
        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteAddEnd), view.getProgressBar(R.id.pbCopyOnWriteAddEnd)).execute(COPY_ON_WRITE_ADD_END);
        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteSearchValue), view.getProgressBar(R.id.pbCopyOnWriteSearchValue)).execute(COPY_ON_WRITE_SEARCH_VALUE);
        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteRemoveBegin), view.getProgressBar(R.id.pbCopyOnWriteRemoveBegin)).execute(COPY_ON_WRITE_REMOVE_BEGIN);
        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteRemoveMiddle), view.getProgressBar(R.id.pbCopyOnWriteRemoveMiddle)).execute(COPY_ON_WRITE_REMOVE_MIDDLE);
        new TaskExecutor(view.getTextView(R.id.txtCopyOnWriteRemoveEnd), view.getProgressBar(R.id.pbCopyOnWriteRemoveEnd)).execute(COPY_ON_WRITE_REMOVE_END);
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
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result) {
                view.setPostLoadingUI();
            }
        }
    }


    private class TaskExecutor extends AsyncTask<String, Void, Void> {
        private TextView cell;
        private ProgressBar indicator;
        Long timeTaskExecution;

        TaskExecutor(TextView textView, ProgressBar progress) {
            cell = textView;
            indicator = progress;
        }

        @Override
        protected void onPreExecute() {
            indicator.setVisibility(VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            String testName = strings[0];

            while (true) {
                if(semaphore.tryAcquire()) {
                    Log.d("myLogs2", "gotAcquire " + testName);
                    break;
                }
            }
            switch (testName) {
                case ARRAY_ADD_BEGIN:
                    timeTaskExecution = CollectionsTest.addInTheBegin(CollectionsTest.arrayList);
                    break;
                case ARRAY_ADD_MIDDLE:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.arrayList);
                    break;
                case ARRAY_ADD_END:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.arrayList);
                    break;
                case ARRAY_SEARCH_VALUE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                    break;
                case ARRAY_REMOVE_BEGIN:
                    timeTaskExecution = CollectionsTest.removeInTheBegin(CollectionsTest.arrayList);
                    break;
                case ARRAY_REMOVE_MIDDLE:
                    timeTaskExecution = CollectionsTest.removeInTheMiddle(CollectionsTest.arrayList);
                    break;
                case ARRAY_REMOVE_END:
                    timeTaskExecution = CollectionsTest.removeInTheEnd(CollectionsTest.arrayList);
                    break;

                case LINKED_ADD_BEGIN:
                    timeTaskExecution = CollectionsTest.addInTheBegin(CollectionsTest.linkedList);
                    break;
                case LINKED_ADD_MIDDLE:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.linkedList);
                    break;
                case LINKED_ADD_END:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.linkedList);
                    break;
                case LINKED_SEARCH_VALUE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.linkedList);
                    break;
                case LINKED_REMOVE_BEGIN:
                    timeTaskExecution = CollectionsTest.removeInTheBegin(CollectionsTest.linkedList);
                    break;
                case LINKED_REMOVE_MIDDLE:
                    timeTaskExecution = CollectionsTest.removeInTheMiddle(CollectionsTest.linkedList);
                    break;
                case LINKED_REMOVE_END:
                    timeTaskExecution = CollectionsTest.removeInTheEnd(CollectionsTest.linkedList);
                    break;

                case COPY_ON_WRITE_BEGIN:
                    timeTaskExecution = CollectionsTest.addInTheBegin(CollectionsTest.copyOnWriteArrayList);
                    break;
                case COPY_ON_WRITE_ADD_MIDDLE:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                    break;
                case COPY_ON_WRITE_ADD_END:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.copyOnWriteArrayList);
                    break;
                case COPY_ON_WRITE_SEARCH_VALUE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.copyOnWriteArrayList);
                    break;
                case COPY_ON_WRITE_REMOVE_BEGIN:
                    timeTaskExecution = CollectionsTest.removeInTheBegin(CollectionsTest.copyOnWriteArrayList);
                    break;
                case COPY_ON_WRITE_REMOVE_MIDDLE:
                    timeTaskExecution = CollectionsTest.removeInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                    break;
                case COPY_ON_WRITE_REMOVE_END:
                    timeTaskExecution = CollectionsTest.removeInTheEnd(CollectionsTest.copyOnWriteArrayList);
                    break;
                case HASH_MAP_ADD:
                    timeTaskExecution = MapsTest.addNew(MapsTest.hashMap);
                    break;
                case HASH_MAP_SEARCH:
                    timeTaskExecution = MapsTest.searchByKey(MapsTest.hashMap);
                    break;
                case HASH_MAP_REMOVE:
                    timeTaskExecution = MapsTest.remove(MapsTest.hashMap);
                    break;
                case TREE_MAP_ADD:
                    timeTaskExecution = MapsTest.addNew(MapsTest.treeMap);
                    break;
                case TREE_MAP_SEARCH:
                    timeTaskExecution = MapsTest.searchByKey(MapsTest.treeMap);
                    break;
                case TREE_MAP_REMOVE:
                    timeTaskExecution = MapsTest.remove(MapsTest.treeMap);
                    break;
            }
            semaphore.release();
            Log.d("myLogs2", "semaphor release");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (cell != null) {
                cell.setText(String.valueOf(timeTaskExecution));
            } else Log.d("myLogs6", "cell = null");
            if(indicator != null) {
                indicator.setVisibility(INVISIBLE);
            }  else Log.d("myLogs6", "indicator = null");
            Log.d("myLogs", "" + timeTaskExecution);
        }
    }
}
