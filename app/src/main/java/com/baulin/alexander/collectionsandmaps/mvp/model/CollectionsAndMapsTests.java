package com.baulin.alexander.collectionsandmaps.mvp.model;

import android.util.Log;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.dagger2.components.AppComponent;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;


import io.reactivex.Observable;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;

public class CollectionsAndMapsTests implements Model {
    static int number;

    private String[] mapsAsyncTasks = {
            HASH_MAP_ADD,
            HASH_MAP_SEARCH,
            HASH_MAP_REMOVE,

            TREE_MAP_ADD,
            TREE_MAP_SEARCH,
            TREE_MAP_REMOVE
    };

    private String[] collectionsAsyncTasks = {
            ARRAY_ADD_BEGIN,
            ARRAY_ADD_MIDDLE,
            ARRAY_ADD_END,
            ARRAY_SEARCH_VALUE,
            ARRAY_REMOVE_BEGIN,
            ARRAY_REMOVE_MIDDLE,
            ARRAY_REMOVE_END,

            LINKED_ADD_BEGIN,
            LINKED_ADD_MIDDLE,
            LINKED_ADD_END,
            LINKED_SEARCH_VALUE,
            LINKED_REMOVE_BEGIN,
            LINKED_REMOVE_MIDDLE,
            LINKED_REMOVE_END,

            COPY_ON_WRITE_BEGIN,
            COPY_ON_WRITE_ADD_MIDDLE,
            COPY_ON_WRITE_ADD_END,
            COPY_ON_WRITE_SEARCH_VALUE,
            COPY_ON_WRITE_REMOVE_BEGIN,
            COPY_ON_WRITE_REMOVE_MIDDLE,
            COPY_ON_WRITE_REMOVE_END
    };

    public CollectionsAndMapsTests() {
        AppComponent component = App.getComponent();
        if(component != null) component.injectTests(this);
    }



    @Override
    public void setNumberOfElements(int numberOfElement) {
        number = numberOfElement;
    }

    public long execute(String task) {
       // Log.d("rxJava", "Emitting item " + task + " on: " + Thread.currentThread().getName());
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
    public Observable<String> getCollectionsTests() {
        return Observable.fromArray(collectionsAsyncTasks);
    }

    @Override
    public Observable<String> getMapsTests() {
        return Observable.fromArray(mapsAsyncTasks);
    }

}
