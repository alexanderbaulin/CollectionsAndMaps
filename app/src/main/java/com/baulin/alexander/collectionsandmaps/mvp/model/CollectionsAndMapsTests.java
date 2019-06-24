package com.baulin.alexander.collectionsandmaps.mvp.model;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.dagger2.components.AppComponent;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListAddElementInBeginTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListAddElementInEndTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListAddElementInMiddleTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListRemoveElementInBeginTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListRemoveElementInEndTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListRemoveElementInMiddleTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListSearchElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.arrayList.ArrayListTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteAddElementInBeginTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteAddElementInEndTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteAddElementInMiddleTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteRemoveElementInBeginTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteRemoveElementInEndTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteRemoveElementInMiddleTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteSearchElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.hashMap.HashMapAddElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.hashMap.HashMapRemoveElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.hashMap.HashMapSearchElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.hashMap.HashMapTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListAddElementInBeginTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListAddElementInEndTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListAddElementInMiddleTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListRemoveElementInBeginTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListRemoveElementInEndTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListRemoveElementInMiddleTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListSearchElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.linkedList.LinkedListTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.treeMap.TreeMapAddElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.treeMap.TreeMapRemoveElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.treeMap.TreeMapSearchElementTest;
import com.baulin.alexander.collectionsandmaps.mvp.model.treeMap.TreeMapTest;


import io.reactivex.Observable;

public class CollectionsAndMapsTests implements Model {


    private Test[] mapsTests = {
            new HashMapAddElementTest(),
            new HashMapSearchElementTest(),
            new HashMapRemoveElementTest(),

            new TreeMapAddElementTest(),
            new TreeMapSearchElementTest(),
            new TreeMapRemoveElementTest()
    };

    private Test[] collectionsTestsAddAndSearch = {
            new ArrayListAddElementInBeginTest(),
            new ArrayListAddElementInMiddleTest(),
            new ArrayListAddElementInEndTest(),
            new ArrayListSearchElementTest(),

            new LinkedListAddElementInBeginTest(),
            new LinkedListAddElementInMiddleTest(),
            new LinkedListAddElementInEndTest(),
            new LinkedListSearchElementTest(),

            new CopyOnWriteAddElementInBeginTest(),
            new CopyOnWriteAddElementInMiddleTest(),
            new CopyOnWriteAddElementInEndTest(),
            new CopyOnWriteSearchElementTest(),
    };

    private Test[] collectionsTestsRemoveEnd = {
            new ArrayListRemoveElementInEndTest(),
            new LinkedListRemoveElementInEndTest(),
            new CopyOnWriteRemoveElementInEndTest()
    };

    private Test[] collectionsTestsRemoveMiddle = {
            new ArrayListRemoveElementInMiddleTest(),
            new LinkedListRemoveElementInMiddleTest(),
            new CopyOnWriteRemoveElementInMiddleTest(),
    };

    private Test[] collectionsTestsRemoveBegin = {
            new ArrayListRemoveElementInBeginTest(),
            new LinkedListRemoveElementInBeginTest(),
            new CopyOnWriteRemoveElementInBeginTest()
    };


    private Fillable[] fillTasks = {
        new ArrayListTest(),
        new LinkedListTest(),
        new CopyOnWriteTest(),
        new HashMapTest(),
        new TreeMapTest()
    };

    public CollectionsAndMapsTests() {
        AppComponent component = App.getComponent();
        if(component != null) component.injectTests(this);
    }

    @Override
    public Observable<Fillable> getFillTasks() {
        return Observable.fromArray(fillTasks);
    }

    @Override
    public Observable<Test> getMapsTests() {
        return Observable.fromArray(mapsTests);
    }

    @Override
    public Observable<Test> getCollectionsTestsAddAndSearch() {
        return Observable.fromArray(collectionsTestsAddAndSearch);
    }

    @Override
    public Observable<Test> getCollectionsTestsDeleteFromEnd() {
        return Observable.fromArray(collectionsTestsRemoveEnd);
    }

    @Override
    public Observable<Test> getCollectionsTestsDeleteFromMiddle() {
        return Observable.fromArray(collectionsTestsRemoveMiddle);
    }

    @Override
    public Observable<Test> getCollectionsTestsDeleteFromBegin() {
        return Observable.fromArray(collectionsTestsRemoveBegin);
    }

}
