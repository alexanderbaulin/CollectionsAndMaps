package com.baulin.alexander.collectionsandmaps.mvp.model.treeMap;

import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.model.Fillable;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest implements Fillable {
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static Integer testKey = 1;
    static Integer testValue = 1;

    @Override
    public void fillWithElements(int elements) {
        for(int i = 0; i < elements; i++) {
            treeMap.put(i, i);
        }
    }
}
