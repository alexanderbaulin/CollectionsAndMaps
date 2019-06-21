package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_REMOVE_BEGIN;

public class LinkedListRemoveElementInBeginTest extends LinkedListTest implements Test {


    private long result;



    @Override
    synchronized public long run() {

        if(linkedList.size() != 0) {
            long timeStart = System.nanoTime();
            linkedList.remove(0);
            long timeEnd = System.nanoTime();

            result = (timeEnd - timeStart) / 1000;
            return result;
        }
        return 0;
    }

    @Override
    public String getStringId() {
        return LINKED_REMOVE_BEGIN;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtLinkedRemoveBegin;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbLinkedRemoveBegin;
    }

    @Override
    public long getResult() {
        return result;
    }
}
