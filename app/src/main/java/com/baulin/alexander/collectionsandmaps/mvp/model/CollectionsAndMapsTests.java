package com.baulin.alexander.collectionsandmaps.mvp.model;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;


import java.util.TreeMap;

import io.reactivex.Observable;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;

public class CollectionsAndMapsTests implements Model {
    static int number;
    private TreeMap<String, Long> timeTasksExecution = new TreeMap<>();
    private TreeMap<String, Integer> progressBars = new TreeMap<>();
    private TreeMap<String, Integer> textViews = new TreeMap<>();;

    public CollectionsAndMapsTests() {
        App.getComponent().injectTests(this);

        putViews(R.id.txtArrayAddBegin, R.id.pbArrayAddBegin, ARRAY_ADD_BEGIN);
        putViews(R.id.txtArrayAddMiddle, R.id.pbArrayAddMiddle, ARRAY_ADD_MIDDLE);
        putViews(R.id.txtArrayAddEnd, R.id.pbArrayAddEnd, ARRAY_ADD_END);
        putViews(R.id.txtArraySearchValue, R.id.pbArraySearchValue, ARRAY_SEARCH_VALUE);
        putViews(R.id.txtArrayRemoveBegin, R.id.pbArrayRemoveBegin, ARRAY_REMOVE_BEGIN);
        putViews(R.id.txtArrayRemoveMiddle, R.id.pbArrayRemoveMiddle, ARRAY_REMOVE_MIDDLE);
        putViews(R.id.txtArrayRemoveEnd, R.id.pbArrayRemoveEnd, ARRAY_REMOVE_END);

        putViews(R.id.txtLinkedAddBegin, R.id.pbLinkedAddBegin, LINKED_ADD_BEGIN);
        putViews(R.id.txtLinkedAddMiddle, R.id.pbLinkedAddMiddle, LINKED_ADD_MIDDLE);
        putViews(R.id.txtLinkedAddEnd, R.id.pbLinkedAddEnd, LINKED_ADD_END);
        putViews(R.id.txtLinkedSearchValue, R.id.pbLinkedSearchValue, LINKED_SEARCH_VALUE);
        putViews(R.id.txtLinkedRemoveBegin, R.id.pbLinkedRemoveBegin, LINKED_REMOVE_BEGIN);
        putViews(R.id.txtLinkedRemoveMiddle, R.id.pbLinkedRemoveMiddle, LINKED_REMOVE_MIDDLE);
        putViews(R.id.txtLinkedRemoveEnd, R.id.pbLinkedRemoveEnd, LINKED_REMOVE_END);

        putViews(R.id.txtCopyOnWriteAddBegin, R.id.pbCopyOnWriteAddBegin, COPY_ON_WRITE_BEGIN);
        putViews(R.id.txtCopyOnWriteAddMiddle, R.id.pbCopyOnWriteAddMiddle, COPY_ON_WRITE_ADD_MIDDLE);
        putViews(R.id.txtCopyOnWriteAddEnd, R.id.pbCopyOnWriteAddEnd, COPY_ON_WRITE_ADD_END);
        putViews(R.id.txtCopyOnWriteSearchValue, R.id.pbCopyOnWriteSearchValue, COPY_ON_WRITE_SEARCH_VALUE);
        putViews(R.id.txtCopyOnWriteRemoveBegin, R.id.pbCopyOnWriteRemoveBegin, COPY_ON_WRITE_REMOVE_BEGIN);
        putViews(R.id.txtCopyOnWriteRemoveMiddle, R.id.pbCopyOnWriteRemoveMiddle, COPY_ON_WRITE_REMOVE_MIDDLE);
        putViews(R.id.txtCopyOnWriteRemoveEnd, R.id.pbCopyOnWriteRemoveEnd, COPY_ON_WRITE_REMOVE_END);

        putViews(R.id.txtHashMapAdd, R.id.pbHashMapAdd, HASH_MAP_ADD);
        putViews(R.id.txtHashMapSearch, R.id.pbHashMapSearch, HASH_MAP_SEARCH);
        putViews(R.id.txtHashMapRemove, R.id.pbHashMapRemove, HASH_MAP_REMOVE);

        putViews(R.id.txtTreeMapAdd, R.id.pbTreeMapAdd, TREE_MAP_ADD);
        putViews(R.id.txtTreeMapSearch, R.id.pbTreeMapSearch, TREE_MAP_SEARCH);
        putViews(R.id.txtTreeMapRemove, R.id.pbTreeMapRemove, TREE_MAP_REMOVE);
    }

    private void putViews(int txtID, int pbID, String task) {
        progressBars.put(task, pbID);
        textViews.put(task, txtID);
    }

    @Override
    public void setNumberOfElements(int numberOfElement) {
        number = numberOfElement;
    }

    public void execute(String task) {
        long time;
        switch (task) {
            case ARRAY_LIST:
                CollectionsTest.fillWithElements(CollectionsTest.arrayList);
                break;
            case LINKED_LIST:
                CollectionsTest.fillWithElements(CollectionsTest.linkedList);
                break;
            case COPY_ARRAY_LIST:
                CollectionsTest.fillWithElements(CollectionsTest.copyOnWriteArrayList);
                break;
            case HASH_MAP:
                MapsTest.fillWithElements(MapsTest.hashMap);
                break;
            case TREE_MAP:
                MapsTest.fillWithElements(MapsTest.treeMap);
                break;

            case ARRAY_ADD_BEGIN:
                time = CollectionsTest.addInTheBegin(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_ADD_BEGIN, time);
                break;
            case ARRAY_ADD_MIDDLE:
                time = CollectionsTest.addInTheMiddle(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_ADD_MIDDLE, time);
                break;
            case ARRAY_ADD_END:
                time = CollectionsTest.addInTheEnd(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_ADD_END, time);
                break;
            case ARRAY_SEARCH_VALUE:
                time = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_SEARCH_VALUE, time);
                break;
            case ARRAY_REMOVE_BEGIN:
                time = CollectionsTest.removeInTheBegin(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_REMOVE_BEGIN, time);
                break;
            case ARRAY_REMOVE_MIDDLE:
                time= CollectionsTest.removeInTheMiddle(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_REMOVE_MIDDLE, time);
                break;
            case ARRAY_REMOVE_END:
                time = CollectionsTest.removeInTheEnd(CollectionsTest.arrayList);
                timeTasksExecution.put(ARRAY_REMOVE_END, time);
                break;

            case LINKED_ADD_BEGIN:
                time = CollectionsTest.addInTheBegin(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_ADD_BEGIN, time);
                break;
            case LINKED_ADD_MIDDLE:
                time = CollectionsTest.addInTheMiddle(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_ADD_MIDDLE, time);
                break;
            case LINKED_ADD_END:
                time = CollectionsTest.addInTheEnd(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_ADD_END, time);
                break;
            case LINKED_SEARCH_VALUE:
                time= CollectionsTest.searchByValue(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_SEARCH_VALUE, time);
                break;
            case LINKED_REMOVE_BEGIN:
                time = CollectionsTest.removeInTheBegin(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_REMOVE_BEGIN, time);
                break;
            case LINKED_REMOVE_MIDDLE:
                time = CollectionsTest.removeInTheMiddle(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_REMOVE_MIDDLE, time);
                break;
            case LINKED_REMOVE_END:
                time = CollectionsTest.removeInTheEnd(CollectionsTest.linkedList);
                timeTasksExecution.put(LINKED_REMOVE_END, time);
                break;

            case COPY_ON_WRITE_BEGIN:
                time = CollectionsTest.addInTheBegin(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_BEGIN, time);
                break;
            case COPY_ON_WRITE_ADD_MIDDLE:
                time = CollectionsTest.addInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_ADD_MIDDLE, time);
                break;
            case COPY_ON_WRITE_ADD_END:
                time= CollectionsTest.addInTheEnd(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_ADD_END, time);
                break;
            case COPY_ON_WRITE_SEARCH_VALUE:
                time = CollectionsTest.searchByValue(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_SEARCH_VALUE, time);
                break;
            case COPY_ON_WRITE_REMOVE_BEGIN:
                time = CollectionsTest.removeInTheBegin(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_REMOVE_BEGIN, time);
                break;
            case COPY_ON_WRITE_REMOVE_MIDDLE:
                time = CollectionsTest.removeInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_REMOVE_MIDDLE, time);
                break;
            case COPY_ON_WRITE_REMOVE_END:
                time = CollectionsTest.removeInTheEnd(CollectionsTest.copyOnWriteArrayList);
                timeTasksExecution.put(COPY_ON_WRITE_REMOVE_END, time);
                break;
            case HASH_MAP_ADD:
                time = MapsTest.addNew(MapsTest.hashMap);
                timeTasksExecution.put(HASH_MAP_ADD, time);
                break;
            case HASH_MAP_SEARCH:
                time = MapsTest.searchByKey(MapsTest.hashMap);
                timeTasksExecution.put(HASH_MAP_SEARCH, time);
                break;
            case HASH_MAP_REMOVE:
                time = MapsTest.remove(MapsTest.hashMap);
                timeTasksExecution.put(HASH_MAP_REMOVE, time);
                break;
            case TREE_MAP_ADD:
                time = MapsTest.addNew(MapsTest.treeMap);
                timeTasksExecution.put(TREE_MAP_ADD, time);
                break;
            case TREE_MAP_SEARCH:
                time= MapsTest.searchByKey(MapsTest.treeMap);
                timeTasksExecution.put( TREE_MAP_SEARCH, time);
                break;
            case TREE_MAP_REMOVE:
                time = MapsTest.remove(MapsTest.treeMap);
                timeTasksExecution.put(TREE_MAP_REMOVE, time);
                break;


        }
    }

    public Observable<String> getFillTasks() {
        return Observable.just(ARRAY_LIST, LINKED_LIST, HASH_MAP, TREE_MAP, COPY_ARRAY_LIST);
    }

    @Override
    public long getExecuteTimeOperation(String task) {
        return timeTasksExecution.get(task);
    }

    @Override
    public Integer getTextView(String testName) {
        return textViews.get(testName);
    }

    @Override
    public Integer getProgressBar(String testName) {
        return progressBars.get(testName);
    }

    @Override
    public Observable<String> getMapsTests() {
        return Observable.just(HASH_MAP_ADD, HASH_MAP_SEARCH, HASH_MAP_REMOVE, TREE_MAP_ADD, TREE_MAP_SEARCH, TREE_MAP_REMOVE);
    }

    @Override
    public Observable<String> getCollectionsTests() {
        String[] operations = {
                ARRAY_ADD_BEGIN, ARRAY_ADD_MIDDLE, ARRAY_ADD_END, ARRAY_SEARCH_VALUE, ARRAY_REMOVE_BEGIN, ARRAY_REMOVE_MIDDLE, ARRAY_REMOVE_END,
                LINKED_ADD_BEGIN, LINKED_ADD_MIDDLE, LINKED_ADD_END, LINKED_SEARCH_VALUE, LINKED_REMOVE_BEGIN, LINKED_REMOVE_MIDDLE, LINKED_REMOVE_END,
                COPY_ON_WRITE_BEGIN, COPY_ON_WRITE_ADD_MIDDLE, COPY_ON_WRITE_ADD_END, COPY_ON_WRITE_SEARCH_VALUE, COPY_ON_WRITE_REMOVE_BEGIN, COPY_ON_WRITE_REMOVE_MIDDLE, COPY_ON_WRITE_REMOVE_END
        };
        return Observable.fromArray(operations);
    }

}
