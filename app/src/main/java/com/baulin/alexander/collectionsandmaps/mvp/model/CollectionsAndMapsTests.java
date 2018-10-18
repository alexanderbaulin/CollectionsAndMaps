package com.baulin.alexander.collectionsandmaps.mvp.model;

import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;


public class CollectionsAndMapsTests implements Model {
    static int number;

    @Override
    public void setNumberOfElements(int numberOfElement) {
        number = numberOfElement;
    }
}
