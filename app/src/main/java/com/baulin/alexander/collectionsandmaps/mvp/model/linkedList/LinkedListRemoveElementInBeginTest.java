package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_REMOVE_BEGIN;

public class LinkedListRemoveElementInBeginTest extends LinkedListTest implements Test {


    private long result;


    @Override
    public void run() {
        long timeStart = System.nanoTime();
        linkedList.remove(0);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart) / 1000;
    }

    @Override
    public String getStringId() {
        return LINKED_REMOVE_BEGIN;
    }

    @Override
    public long getResult() {
        return result;
    }
}
