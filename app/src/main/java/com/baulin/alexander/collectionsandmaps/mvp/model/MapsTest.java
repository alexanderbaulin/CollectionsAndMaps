package com.baulin.alexander.collectionsandmaps.mvp.model;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsTest {
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private static Integer testKey = 1;
    private static Integer testValue = 1;

    public static void fillWithElements(Map<Integer, Integer> map) {
        for(int i = 0; i < CollectionsAndMapsTests.number; i++) {
            map.put(i, i);
        }
        Log.d("myLogs", map.getClass() + " filled with elements");
    }

    public synchronized static long addNew(Map<Integer, Integer> map) {
        long timeStart = System.nanoTime();
        map.put(testKey, testValue);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    public synchronized static long searchByKey(Map<Integer, Integer> map) {
        long timeStart = System.nanoTime();
        map.get(testKey);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    public synchronized static long remove(Map<Integer, Integer> map) {
        long timeStart = System.nanoTime();
        map.remove(testKey);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }
}