package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


import com.baulin.alexander.collectionsandmaps.mvp.model.TestTask;

import io.reactivex.Observable;

public interface Model {
    void setNumberOfElements(int number);
    long execute(String task);
    Observable<String> getFillTasks();
    Observable<String> getMapsTests();
    Observable<TestTask> getCollectionsTests();
    long getTestTime(String name);
}
