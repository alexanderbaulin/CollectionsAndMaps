package com.baulin.alexander.collectionsandmaps.mvp.model.hashMap;

import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.model.Fillable;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest implements Fillable {
    public static java.util.HashMap<Integer, Integer> hashMap = new java.util.HashMap<>();
    protected static Integer testKey = 1;
    protected static Integer testValue = 1;


    @Override
    public void fillWithElements(int elements) {
        for(int i = 0; i < elements; i++) {
            hashMap.put(i, i);
        }
    }
}
