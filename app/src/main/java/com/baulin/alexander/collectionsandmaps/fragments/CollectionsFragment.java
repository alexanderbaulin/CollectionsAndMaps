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
import com.baulin.alexander.collectionsandmaps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsFragment extends Fragment {
    View view;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collections, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void calculateTimeOperations() {
        new TaskExecutor(arrayAddBegin).execute(CollectionsTest.ARRAY_ADD_BEGIN);
        new TaskExecutor(arrayAddMiddle).execute(CollectionsTest.ARRAY_ADD_MIDDLE);
        new TaskExecutor(arrayAddEnd).execute(CollectionsTest.ARRAY_ADD_END);
        new TaskExecutor(arraySearchValue).execute(CollectionsTest.ARRAY_SEARCH_VALUE);
        new TaskExecutor(arrayRemoveBegin).execute(CollectionsTest.ARRAY_REMOVE_BEGIN);
        new TaskExecutor(arrayRemoveMiddle).execute(CollectionsTest.ARRAY_REMOVE_MIDDLE);
        new TaskExecutor(arrayRemoveEnd).execute(CollectionsTest.ARRAY_REMOVE_END);

        new TaskExecutor(linkedAddBegin).execute(CollectionsTest.LINKED_ADD_BEGIN);
        new TaskExecutor(linkedAddMiddle).execute(CollectionsTest.LINKED_ADD_MIDDLE);
        new TaskExecutor(linkedAddEnd).execute(CollectionsTest.LINKED_ADD_END);
        new TaskExecutor(linkedSearchValue).execute(CollectionsTest.LINKED_SEARCH_VALUE);
        new TaskExecutor(linkedRemoveBegin).execute(CollectionsTest.LINKED_REMOVE_BEGIN);
        new TaskExecutor(linkedRemoveMiddle).execute(CollectionsTest.LINKED_REMOVE_MIDDLE);
        new TaskExecutor(linkedRemoveEnd).execute(CollectionsTest.LINKED_REMOVE_END);

        new TaskExecutor(copyOnWriteAddBegin).execute(CollectionsTest.COPY_ON_WRITE_BEGIN);
        new TaskExecutor(copyOnWriteAddMiddle).execute(CollectionsTest.COPY_ON_WRITE_ADD_MIDDLE);
        new TaskExecutor(copyOnWriteAddEnd).execute(CollectionsTest.COPY_ON_WRITE_ADD_END);
        new TaskExecutor(copyOnWriteSearchValue).execute(CollectionsTest.COPY_ON_WRITE_SEARCH_VALUE);
        new TaskExecutor(copyOnWriteRemoveBegin).execute(CollectionsTest.COPY_ON_WRITE_REMOVE_BEGIN);
        new TaskExecutor(copyOnWriteRemoveMiddle).execute(CollectionsTest.COPY_ON_WRITE_REMOVE_MIDDLE);
        new TaskExecutor(copyOnWriteRemoveEnd).execute(CollectionsTest.COPY_ON_WRITE_REMOVE_END);

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
                case CollectionsTest.ARRAY_ADD_BEGIN:
                    timeTaskExecution = CollectionsTest.addInTheBegin(CollectionsTest.arrayList);
                    break;
                case CollectionsTest.ARRAY_ADD_MIDDLE:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.arrayList);
                    break;
                case CollectionsTest.ARRAY_ADD_END:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.arrayList);
                    break;
                case CollectionsTest.ARRAY_SEARCH_VALUE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                    break;
                case CollectionsTest.ARRAY_REMOVE_BEGIN:
                    timeTaskExecution = CollectionsTest.removeInTheBegin(CollectionsTest.arrayList);
                    break;
                case CollectionsTest.ARRAY_REMOVE_MIDDLE:
                    timeTaskExecution = CollectionsTest.removeInTheMiddle(CollectionsTest.arrayList);
                    break;
                case CollectionsTest.ARRAY_REMOVE_END:
                    timeTaskExecution = CollectionsTest.removeInTheEnd(CollectionsTest.arrayList);
                    break;

                case CollectionsTest.LINKED_ADD_BEGIN:
                    timeTaskExecution = CollectionsTest.addInTheBegin(CollectionsTest.linkedList);
                    break;
                case CollectionsTest.LINKED_ADD_MIDDLE:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.linkedList);
                    break;
                case CollectionsTest.LINKED_ADD_END:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.linkedList);
                    break;
                case CollectionsTest.LINKED_SEARCH_VALUE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.linkedList);
                    break;
                case CollectionsTest.LINKED_REMOVE_BEGIN:
                    timeTaskExecution = CollectionsTest.removeInTheBegin(CollectionsTest.linkedList);
                    break;
                case CollectionsTest.LINKED_REMOVE_MIDDLE:
                    timeTaskExecution = CollectionsTest.removeInTheMiddle(CollectionsTest.linkedList);
                    break;
                case CollectionsTest.LINKED_REMOVE_END:
                    timeTaskExecution = CollectionsTest.removeInTheEnd(CollectionsTest.linkedList);
                    break;

                case CollectionsTest.COPY_ON_WRITE_BEGIN:
                    timeTaskExecution = CollectionsTest.addInTheBegin(CollectionsTest.copyOnWriteArrayList);
                    break;
                case CollectionsTest.COPY_ON_WRITE_ADD_MIDDLE:
                    timeTaskExecution = CollectionsTest.addInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                    break;
                case CollectionsTest.COPY_ON_WRITE_ADD_END:
                    timeTaskExecution = CollectionsTest.addInTheEnd(CollectionsTest.copyOnWriteArrayList);
                    break;
                case CollectionsTest.COPY_ON_WRITE_SEARCH_VALUE:
                    timeTaskExecution = CollectionsTest.searchByValue(CollectionsTest.copyOnWriteArrayList);
                    break;
                case CollectionsTest.COPY_ON_WRITE_REMOVE_BEGIN:
                    timeTaskExecution = CollectionsTest.removeInTheBegin(CollectionsTest.copyOnWriteArrayList);
                    break;
                case CollectionsTest.COPY_ON_WRITE_REMOVE_MIDDLE:
                    timeTaskExecution = CollectionsTest.removeInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                    break;
                case CollectionsTest.COPY_ON_WRITE_REMOVE_END:
                    timeTaskExecution = CollectionsTest.removeInTheEnd(CollectionsTest.copyOnWriteArrayList);
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
