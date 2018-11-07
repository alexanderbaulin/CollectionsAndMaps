package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


import io.reactivex.Observable;

public interface Model {
    void setNumberOfElements(int number);
    long execute(String task);
    Observable<String> getFillTasks();
    Observable<String> getMapsTests();
    Observable<String> getCollectionsTests();
}
