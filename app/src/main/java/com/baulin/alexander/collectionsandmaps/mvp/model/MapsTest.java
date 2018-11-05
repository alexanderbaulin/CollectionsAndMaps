package com.baulin.alexander.collectionsandmaps.mvp.model;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MapsTest {
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private static Integer testKey = 1;
    private static Integer testValue = 1;

    static void fillWithElements(Map<Integer, Integer> map) {
        for(int i = 0; i < CollectionsAndMapsTests.number; i++) {
            map.put(i, i);
        }
        Log.d("myLogs", map.getClass() + " filled with elements");
    }

    synchronized static long addNew(Map<Integer, Integer> map) {
        long timeStart = System.nanoTime();
        map.put(testKey, testValue);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long searchByKey(Map<Integer, Integer> map) {
        long timeStart = System.nanoTime();
        map.get(testKey);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long remove(Map<Integer, Integer> map) {
        long timeStart = System.nanoTime();
        map.remove(testKey);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }
}
