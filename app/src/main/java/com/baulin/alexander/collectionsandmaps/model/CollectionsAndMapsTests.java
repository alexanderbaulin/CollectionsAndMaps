package com.baulin.alexander.collectionsandmaps.model;

import com.baulin.alexander.collectionsandmaps.interfaces.Model;


public class CollectionsAndMapsTests implements Model {
    static int number;

    @Override
    public void setNumberOfElement(int numberOfElement) {
        number = numberOfElement;
    }
}
