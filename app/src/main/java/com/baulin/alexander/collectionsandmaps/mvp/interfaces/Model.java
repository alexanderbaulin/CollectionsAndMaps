package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


import com.baulin.alexander.collectionsandmaps.mvp.model.TestTask;

import java.util.ArrayList;

import io.reactivex.Observable;

public interface Model {
    void setNumberOfElements(int number);
    long execute(String task);
    Observable<String> getFillTasks();
    ArrayList<Observable<TestTask>> getMapsTests();
    ArrayList<Observable<TestTask>>  getCollectionsTests();
}
