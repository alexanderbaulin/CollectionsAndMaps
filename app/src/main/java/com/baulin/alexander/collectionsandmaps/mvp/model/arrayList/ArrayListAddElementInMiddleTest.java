package com.baulin.alexander.collectionsandmaps.mvp.model.arrayList;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.ARRAY_ADD_MIDDLE;

public class ArrayListAddElementInMiddleTest extends ArrayListTest implements Test {

    private long result;


    @Override
    public void run() {
        long timeStart = System.nanoTime();
        arrayList.add(arrayList.size()/2, testElement);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;
    }

    @Override
    public String getStringId() {
        return ARRAY_ADD_MIDDLE;
    }

    @Override
    public long getResult() {
        return result;
    }

}
