package com.baulin.alexander.collectionsandmaps.mvp.model;



import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


class CollectionsTest {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();
    static CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private static Integer testElement = 1;

    static void fillWithElements(List<Integer> list) {
        for(int i = 0; i < CollectionsAndMapsTests.number; i++) {
           // if(list.getClass().toString().equals("class java.util.concurrent.CopyOnWriteArrayList"))  Log.d("myLogs", list.getClass() + "add element " + i);
            list.add(i);
        }
//        Log.d("myLogs", list.getClass() + " filled with elements");
    }

    synchronized static long addInTheBegin(List<Integer> list) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeStart = System.nanoTime();
        list.add(0, testElement);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long addInTheMiddle(List<Integer> list) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeStart = System.nanoTime();
        list.add(list.size()/2, testElement);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

     synchronized static long addInTheEnd(List<Integer> list) {
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
        long timeStart = System.nanoTime();
        list.add(testElement);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long searchByValue(List<Integer> list) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeStart = System.nanoTime();
        list.indexOf(list.size()/2);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long removeInTheBegin(List<Integer> list) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeStart = System.nanoTime();
        list.remove(0);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long removeInTheEnd(List<Integer> list) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeStart = System.nanoTime();
        list.remove(list.size()-1);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }

    synchronized static long removeInTheMiddle(List<Integer> list) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timeStart = System.nanoTime();
        list.remove(list.size()/2);
        long timeEnd = System.nanoTime();
        return (timeEnd - timeStart)/1000;
    }
}
