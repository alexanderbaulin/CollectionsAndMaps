package com.baulin.alexander.collectionsandmaps;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsTest {

    public static final String HASH_MAP_ADD = "hashMapAdd";
    public static final String HASH_MAP_SEARCH = "hashMapSearch";
    public static final String HASH_MAP_REMOVE = "hashMapRemove";

    public static final String TREE_MAP_ADD = "treeMapAdd";
    public static final String TREE_MAP_SEARCH = "treeMapSearch";
    public static final String TREE_MAP_REMOVE = "treeMapRemove";


    public static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private static Integer testKey = 1;
    private static Integer testValue = 1;

    public static void fillWithElements(Map<Integer, Integer> map) {
        for(int i = 0; i < 100; i++) {
            map.put(i, i);
        }
        Log.d("myLogs", map.getClass() + " filled with elements");
    }

    public static long addNew(Map<Integer, Integer> map) {
        long timeStart = System.currentTimeMillis();
        map.put(testKey, testValue);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long searchByKey(Map<Integer, Integer> map) {
        long timeStart = System.currentTimeMillis();
        map.get(testKey);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long remove(Map<Integer, Integer> map) {
        long timeStart = System.currentTimeMillis();
        map.remove(testKey);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }
}
