package com.baulin.alexander.collectionsandmaps.mvp.model.arrayList;

import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.model.Fillable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest implements Fillable {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    protected static Integer testElement = 1;

    @Override
    public void fillWithElements(int elements) {
        for(int i = 0; i < elements; i++) {
            arrayList.add(i);
        }
    }
}
