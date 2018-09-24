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

public class CollectionsFragment extends Fragment {
    View view;
    TextView arrayAddBegin, arrayAddMiddle, arrayAddEnd, arraySearchValue, arrayRemoveBegin, arrayRemoveMiddle, arrayRemoveEnd;
    TextView linkedAddBegin, linkedAddMiddle, linkedAddEnd, linkedSearchValue, linkedRemoveBegin, linkedRemoveMiddle, linkedRemoveEnd;
    TextView copyOnWriteAddBegin, copyOnWriteAddMiddle, copyOnWriteAddEnd, copyOnWriteSearchValue, copyOnWriteRemoveBegin, copyOnWriteRemoveMiddle, copyOnWriteRemoveEnd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collections, container, false);

        arrayAddBegin = view.findViewById(R.id.txtArrayAddBegin);
        arrayAddMiddle = view.findViewById(R.id.txtArrayAddMiddle);
        arrayAddEnd = view.findViewById(R.id.txtArrayAddEnd);
        arraySearchValue = view.findViewById(R.id.txtArraySearchValue);
        arrayRemoveBegin = view.findViewById(R.id.txtArrayRemoveBegin);
        arrayRemoveMiddle = view.findViewById(R.id.txtArrayRemoveMiddle);
        arrayRemoveEnd = view.findViewById(R.id.txtArrayRemoveEnd);

        linkedAddBegin = view.findViewById(R.id.txtLinkedAddBegin);
        linkedAddMiddle = view.findViewById(R.id.txtLinkedAddMiddle);
        linkedAddEnd = view.findViewById(R.id.txtLinkedAddEnd);
        linkedSearchValue = view.findViewById(R.id.txtLinkedSearchValue);
        linkedRemoveBegin = view.findViewById(R.id.txtLinkedRemoveBegin);
        linkedRemoveMiddle = view.findViewById(R.id.txtLinkedRemoveMiddle);
        linkedRemoveEnd = view.findViewById(R.id.txtLinkedRemoveEnd);

        copyOnWriteAddBegin = view.findViewById(R.id.txtCopyOnWriteAddBegin);
        copyOnWriteAddMiddle = view.findViewById(R.id.txtCopyOnWriteAddMiddle);
        copyOnWriteAddEnd = view.findViewById(R.id.txtCopyOnWriteAddEnd);
        copyOnWriteSearchValue = view.findViewById(R.id.txtCopyOnWriteSearchValue);
        copyOnWriteRemoveBegin = view.findViewById(R.id.txtCopyOnWriteRemoveBegin);
        copyOnWriteRemoveMiddle = view.findViewById(R.id.txtCopyOnWriteRemoveMiddle);
        copyOnWriteRemoveEnd = view.findViewById(R.id.txtCopyOnWriteRemoveEnd);

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
