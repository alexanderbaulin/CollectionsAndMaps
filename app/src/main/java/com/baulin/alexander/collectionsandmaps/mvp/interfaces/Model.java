package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


import io.reactivex.Observable;

public interface Model {
    void setNumberOfElements(int number);
    void execute(String task);
    Observable<String> getFillTasks();
    long getExecuteTimeOperation(String task);
    Integer getTextView(String testName);
    Integer getProgressBar(String testName);
    Observable<String> getMapsTests();
    Observable<String> getCollectionsTests();
}
