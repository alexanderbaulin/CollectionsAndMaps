package com.baulin.alexander.collectionsandmaps.mvp.model;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;


import io.reactivex.Observable;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;

public class CollectionsAndMapsTests implements Model {
    static int number;

    private TestTask[] mapsAsyncTasks = {
            new TestTask(R.id.txtHashMapAdd, R.id.pbHashMapAdd, HASH_MAP_ADD),
            new TestTask(R.id.txtHashMapSearch, R.id.pbHashMapSearch, HASH_MAP_SEARCH),
            new TestTask(R.id.txtHashMapRemove, R.id.pbHashMapRemove, HASH_MAP_REMOVE),

            new TestTask(R.id.txtTreeMapAdd, R.id.pbTreeMapAdd, TREE_MAP_ADD),
            new TestTask(R.id.txtTreeMapSearch, R.id.pbTreeMapSearch, TREE_MAP_SEARCH),
            new TestTask(R.id.txtTreeMapRemove, R.id.pbTreeMapRemove, TREE_MAP_REMOVE)
    };

    private TestTask[] collectionsAsyncTasks = {
            new TestTask(R.id.txtArrayAddBegin, R.id.pbArrayAddBegin, ARRAY_ADD_BEGIN),
            new TestTask(R.id.txtArrayAddMiddle, R.id.pbArrayAddMiddle, ARRAY_ADD_MIDDLE),
            new TestTask(R.id.txtArrayAddEnd, R.id.pbArrayAddEnd, ARRAY_ADD_END),
            new TestTask(R.id.txtArraySearchValue, R.id.pbArraySearchValue, ARRAY_SEARCH_VALUE),
            new TestTask(R.id.txtArrayRemoveBegin, R.id.pbArrayRemoveBegin, ARRAY_REMOVE_BEGIN),
            new TestTask(R.id.txtArrayRemoveMiddle, R.id.pbArrayRemoveMiddle, ARRAY_REMOVE_MIDDLE),
            new TestTask(R.id.txtArrayRemoveEnd, R.id.pbArrayRemoveEnd, ARRAY_REMOVE_END),

            new TestTask(R.id.txtLinkedAddBegin, R.id.pbLinkedAddBegin, LINKED_ADD_BEGIN),
            new TestTask(R.id.txtLinkedAddMiddle, R.id.pbLinkedAddMiddle, LINKED_ADD_MIDDLE),
            new TestTask(R.id.txtLinkedAddEnd, R.id.pbLinkedAddEnd, LINKED_ADD_END),
            new TestTask(R.id.txtLinkedSearchValue, R.id.pbLinkedSearchValue, LINKED_SEARCH_VALUE),
            new TestTask(R.id.txtLinkedRemoveBegin, R.id.pbLinkedRemoveBegin, LINKED_REMOVE_BEGIN),
            new TestTask(R.id.txtLinkedRemoveMiddle, R.id.pbLinkedRemoveMiddle, LINKED_REMOVE_MIDDLE),
            new TestTask(R.id.txtLinkedRemoveEnd, R.id.pbLinkedRemoveEnd, LINKED_REMOVE_END),

            new TestTask(R.id.txtCopyOnWriteAddBegin, R.id.pbCopyOnWriteAddBegin, COPY_ON_WRITE_BEGIN),
            new TestTask(R.id.txtCopyOnWriteAddMiddle, R.id.pbCopyOnWriteAddMiddle, COPY_ON_WRITE_ADD_MIDDLE),
            new TestTask(R.id.txtCopyOnWriteAddEnd, R.id.pbCopyOnWriteAddEnd, COPY_ON_WRITE_ADD_END),
            new TestTask(R.id.txtCopyOnWriteSearchValue, R.id.pbCopyOnWriteSearchValue, COPY_ON_WRITE_SEARCH_VALUE),
            new TestTask(R.id.txtCopyOnWriteRemoveBegin, R.id.pbCopyOnWriteRemoveBegin, COPY_ON_WRITE_REMOVE_BEGIN),
            new TestTask(R.id.txtCopyOnWriteRemoveMiddle, R.id.pbCopyOnWriteRemoveMiddle, COPY_ON_WRITE_REMOVE_MIDDLE),
            new TestTask(R.id.txtCopyOnWriteRemoveEnd, R.id.pbCopyOnWriteRemoveEnd, COPY_ON_WRITE_REMOVE_END)
    };

    public CollectionsAndMapsTests() {
        App.getComponent().injectTests(this);
    }



    @Override
    public void setNumberOfElements(int numberOfElement) {
        number = numberOfElement;
    }

    public long execute(String task) {
        long time = 0;
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
                break;
            case ARRAY_ADD_MIDDLE:
                time = CollectionsTest.addInTheMiddle(CollectionsTest.arrayList);
                break;
            case ARRAY_ADD_END:
                time = CollectionsTest.addInTheEnd(CollectionsTest.arrayList);
                break;
            case ARRAY_SEARCH_VALUE:
                time = CollectionsTest.searchByValue(CollectionsTest.arrayList);
                break;
            case ARRAY_REMOVE_BEGIN:
                time = CollectionsTest.removeInTheBegin(CollectionsTest.arrayList);
                break;
            case ARRAY_REMOVE_MIDDLE:
                time= CollectionsTest.removeInTheMiddle(CollectionsTest.arrayList);
                break;
            case ARRAY_REMOVE_END:
                time = CollectionsTest.removeInTheEnd(CollectionsTest.arrayList);
                break;

            case LINKED_ADD_BEGIN:
                time = CollectionsTest.addInTheBegin(CollectionsTest.linkedList);
                break;
            case LINKED_ADD_MIDDLE:
                time = CollectionsTest.addInTheMiddle(CollectionsTest.linkedList);
                break;
            case LINKED_ADD_END:
                time = CollectionsTest.addInTheEnd(CollectionsTest.linkedList);
                break;
            case LINKED_SEARCH_VALUE:
                time= CollectionsTest.searchByValue(CollectionsTest.linkedList);
                break;
            case LINKED_REMOVE_BEGIN:
                time = CollectionsTest.removeInTheBegin(CollectionsTest.linkedList);
                break;
            case LINKED_REMOVE_MIDDLE:
                time = CollectionsTest.removeInTheMiddle(CollectionsTest.linkedList);
                break;
            case LINKED_REMOVE_END:
                time = CollectionsTest.removeInTheEnd(CollectionsTest.linkedList);
                break;

            case COPY_ON_WRITE_BEGIN:
                time = CollectionsTest.addInTheBegin(CollectionsTest.copyOnWriteArrayList);
                break;
            case COPY_ON_WRITE_ADD_MIDDLE:
                time = CollectionsTest.addInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                break;
            case COPY_ON_WRITE_ADD_END:
                time= CollectionsTest.addInTheEnd(CollectionsTest.copyOnWriteArrayList);
                break;
            case COPY_ON_WRITE_SEARCH_VALUE:
                time = CollectionsTest.searchByValue(CollectionsTest.copyOnWriteArrayList);
                break;
            case COPY_ON_WRITE_REMOVE_BEGIN:
                time = CollectionsTest.removeInTheBegin(CollectionsTest.copyOnWriteArrayList);
                break;
            case COPY_ON_WRITE_REMOVE_MIDDLE:
                time = CollectionsTest.removeInTheMiddle(CollectionsTest.copyOnWriteArrayList);
                break;
            case COPY_ON_WRITE_REMOVE_END:
                time = CollectionsTest.removeInTheEnd(CollectionsTest.copyOnWriteArrayList);
                break;
            case HASH_MAP_ADD:
                time = MapsTest.addNew(MapsTest.hashMap);
                break;
            case HASH_MAP_SEARCH:
                time = MapsTest.searchByKey(MapsTest.hashMap);
                break;
            case HASH_MAP_REMOVE:
                time = MapsTest.remove(MapsTest.hashMap);
                break;
            case TREE_MAP_ADD:
                time = MapsTest.addNew(MapsTest.treeMap);
                break;
            case TREE_MAP_SEARCH:
                time= MapsTest.searchByKey(MapsTest.treeMap);
                break;
            case TREE_MAP_REMOVE:
                time = MapsTest.remove(MapsTest.treeMap);
                break;


        }
        return time;
    }

    public Observable<String> getFillTasks() {
        return Observable.just(ARRAY_LIST, LINKED_LIST, HASH_MAP, TREE_MAP, COPY_ARRAY_LIST);
    }

    @Override
    public Observable<TestTask> getCollectionsTests() {
        return Observable.fromArray(collectionsAsyncTasks);
    }

    @Override
    public Observable<TestTask> getMapsTests() {
        return Observable.fromArray(mapsAsyncTasks);
    }

}
