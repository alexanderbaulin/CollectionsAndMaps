package com.baulin.alexander.collectionsandmaps.mvp.model;

import com.baulin.alexander.collectionsandmaps.TestClass;
import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;

import javax.inject.Inject;


public class CollectionsAndMapsTests implements Model {
    static int number;

    @Inject
    TestClass testClass;

    public CollectionsAndMapsTests() {
        App.getComponent().injectTests(this);
    }

    @Override
    public void setNumberOfElements(int numberOfElement) {
        number = numberOfElement;
    }
}
