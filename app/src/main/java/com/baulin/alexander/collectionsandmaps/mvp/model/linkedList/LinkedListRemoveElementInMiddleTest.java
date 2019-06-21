package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_REMOVE_MIDDLE;

public class LinkedListRemoveElementInMiddleTest extends LinkedListTest implements Test {

    private long result;



    @Override
    public long run() {
        if(linkedList.size() != 0) {
            long timeStart = System.nanoTime();
            linkedList.remove(linkedList.size() / 2);
            long timeEnd = System.nanoTime();

            result = (timeEnd - timeStart) / 1000;

            return result;
        }
        return 0;
    }

    @Override
    public String getStringId() {
        return LINKED_REMOVE_MIDDLE;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtLinkedRemoveMiddle;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbLinkedRemoveMiddle;
    }

    @Override
    public long getResult() {
        return result;
    }
}
