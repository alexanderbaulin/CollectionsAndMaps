package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_ADD_END;

public class LinkedListAddElementInEndTest extends LinkedListTest implements Test {

    private long result;


    @Override
    public void run() {
        long timeStart = System.nanoTime();
        linkedList.add(testElement);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;
    }

    @Override
    public String getStringId() {
        return LINKED_ADD_END;
    }

    @Override
    public long getResult() {
        return result;
    }
}
