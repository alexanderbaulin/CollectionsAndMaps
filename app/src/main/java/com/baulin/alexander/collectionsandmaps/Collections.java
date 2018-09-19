package com.baulin.alexander.collectionsandmaps;


import android.os.AsyncTask;

import com.baulin.alexander.collectionsandmaps.activities.Main;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;


public class Collections {
    public static final String ARRAY_LIST_ADD_IN_THE_BEGIN = "arrayListAddInTheBegin";
    public static final String ARRAY_LIST_ADD_IN_THE_END = "arrayListAddInTheEnd";


    public long arrayListAddInTheBegin() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            arrayList.add(0, i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long arrayListAddInTheEnd() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long arrayListAddInTheMiddle() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            arrayList.add(arrayList.size()/2, i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long arrayListSearchByValue() {
        ArrayList<Integer> arrayList = new ArrayList<>(1000000);
        long timeStart = System.currentTimeMillis();
        arrayList.indexOf(500000);
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long arrayListRemoveInTheBegin() {
        ArrayList<Integer> arrayList = new ArrayList<>(1000000);
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            arrayList.remove(0);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long arrayListRemoveInTheEnd() {
        ArrayList<Integer> arrayList = new ArrayList<>(1000000);
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            arrayList.remove(arrayList.size()-1);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long arrayListRemoveInTheMiddle() {
        ArrayList<Integer> arrayList = new ArrayList<>(1000000);
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            arrayList.remove(arrayList.size()/2);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListAddInTheBegin() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(0, i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListAddInTheEnd() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListAddInTheMiddle() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(linkedList.size()/2, i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListSearchByValue() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.indexOf(500000);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListRemoveInTheBegin() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.remove(0);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListRemoveInTheEnd() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.remove(linkedList.size()-1);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long linkedListRemoveInTheMiddle() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            linkedList.remove(linkedList.size()/2);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListAddInTheBegin() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(0, i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListAddInTheEnd() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListAddInTheMiddle() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(copyOnWriteArrayList.size()/2, i);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListSearchByValue() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.indexOf(2000000);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListRemoveInTheBegin() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.remove(0);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListRemoveInTheEnd() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.remove(copyOnWriteArrayList.size()-1);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    public long copyListRemoveInTheMiddle() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.add(i);
        }
        long timeStart = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            copyOnWriteArrayList.remove(copyOnWriteArrayList.size()/2);
        }
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }


}
