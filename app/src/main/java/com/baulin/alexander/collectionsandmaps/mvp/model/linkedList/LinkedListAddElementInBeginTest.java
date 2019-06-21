package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_ADD_BEGIN;

public class LinkedListAddElementInBeginTest extends LinkedListTest implements Test {

    private long result;


    @Override
    public long run() {

        long timeStart = System.nanoTime();
        linkedList.add(0, testElement);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return LINKED_ADD_BEGIN;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtLinkedAddBegin;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbLinkedAddBegin;
    }

    @Override
    public long getResult() {
        return result;
    }
}
