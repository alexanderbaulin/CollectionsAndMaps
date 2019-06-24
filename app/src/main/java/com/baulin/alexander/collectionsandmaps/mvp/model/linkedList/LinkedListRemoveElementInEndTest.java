package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_REMOVE_END;

public class LinkedListRemoveElementInEndTest extends LinkedListTest implements Test {

    private long result;



    @Override
    public long run() {
        long timeStart = System.nanoTime();
        linkedList.remove(linkedList.size() - 1);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart) / 1000;

        return result;
    }

    @Override
    public String getStringId() {
        return LINKED_REMOVE_END;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtLinkedRemoveEnd;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbLinkedRemoveEnd;
    }

    @Override
    public long getResult() {
        return result;
    }
}
