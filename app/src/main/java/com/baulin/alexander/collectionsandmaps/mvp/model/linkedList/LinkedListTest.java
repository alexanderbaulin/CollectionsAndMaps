package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.model.Fillable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedListTest implements Fillable {
    public static LinkedList<Integer> linkedList = new LinkedList<>();
    protected static Integer testElement = 1;


    @Override
    public void fillWithElements(int elements) {
        for(int i = 0; i < elements; i++) {
            linkedList.add(i);
        }
    }
}
