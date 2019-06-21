package com.baulin.alexander.collectionsandmaps.mvp.model.linkedList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.LINKED_SEARCH_VALUE;

public class LinkedListSearchElementTest extends LinkedListTest implements Test {

    private long result;


    @Override
    public long run() {

        long timeStart = System.nanoTime();
        linkedList.indexOf(linkedList.size()/2);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return LINKED_SEARCH_VALUE;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtLinkedSearchValue;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbLinkedSearchValue;
    }

    @Override
    public long getResult() {
        return result;
    }
}
