package com.baulin.alexander.collectionsandmaps;



import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CollectionsTest {
    public static final String ARRAY_ADD_BEGIN = "arrayAddBegin";
    public static final String ARRAY_ADD_MIDDLE = "arrayAddMiddle";
    public static final String ARRAY_ADD_END = "arrayAddEnd";
    public static final String ARRAY_SEARCH_VALUE = "arraySearchValue";
    public static final String ARRAY_REMOVE_BEGIN = "arrayRemoveBegin";
    public static final String ARRAY_REMOVE_MIDDLE = "arrayRemoveMiddle";
    public static final String ARRAY_REMOVE_END = "arrayRemoveEnd";

    public static final String LINKED_ADD_BEGIN = "linkedAddBegin";
    public static final String LINKED_ADD_MIDDLE = "linkedAddMiddle";
    public static final String LINKED_ADD_END = "linkedAddEnd";
    public static final String LINKED_SEARCH_VALUE = "linkedSearchValue";
    public static final String LINKED_REMOVE_BEGIN = "linkedRemoveBegin";
    public static final String LINKED_REMOVE_MIDDLE = "linkedRemoveMiddle";
    public static final String LINKED_REMOVE_END = "linkedRemoveEnd";

    public static final String COPY_ON_WRITE_BEGIN = "copyOnWriteAddBegin";
    public static final String COPY_ON_WRITE_ADD_MIDDLE = "copyOnWriteAddMiddle";
    public static final String COPY_ON_WRITE_ADD_END = "copyOnWriteAddEnd";
    public static final String COPY_ON_WRITE_SEARCH_VALUE = "copyOnWriteSearchValue";
    public static final String COPY_ON_WRITE_REMOVE_BEGIN = "copyOnWriteRemoveBegin";
    public static final String COPY_ON_WRITE_REMOVE_MIDDLE = "copyOnWriteRemoveMiddle";
    public static final String COPY_ON_WRITE_REMOVE_END = "copyOnWriteRemoveEnd";

    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static LinkedList<Integer> linkedList = new LinkedList<>();
    public static CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private static Integer testElement = 1;

    public static void fillWithElements(List<Integer> list) {
        for(int i = 0; i < 100; i++) {
           // if(list.getClass().toString().equals("class java.util.concurrent.CopyOnWriteArrayList"))  Log.d("myLogs", list.getClass() + "add element " + i);
            list.add(i);
        }
       Log.d("myLogs", list.getClass() + " filled with elements");
    }

    public static long addInTheBegin(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.add(0, testElement);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long addInTheMiddle(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.add(list.size()/2, testElement);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long addInTheEnd(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.add(testElement);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long searchByValue(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.indexOf(list.size()/2);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long removeInTheBegin(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.remove(0);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long removeInTheEnd(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.remove(list.size()-1);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public static long removeInTheMiddle(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        list.remove(list.size()/2);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }
}
