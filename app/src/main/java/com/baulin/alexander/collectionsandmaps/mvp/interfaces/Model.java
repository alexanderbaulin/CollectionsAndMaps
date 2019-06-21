package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


import com.baulin.alexander.collectionsandmaps.mvp.model.Fillable;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import io.reactivex.Observable;

public interface Model {
    Observable<Test> getMapsTests();
    Observable<Test> getCollectionsTests();
    Observable<Fillable> getFillTasks();
}
