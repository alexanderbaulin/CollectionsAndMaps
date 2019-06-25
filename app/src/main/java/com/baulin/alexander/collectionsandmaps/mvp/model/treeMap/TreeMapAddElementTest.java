package com.baulin.alexander.collectionsandmaps.mvp.model.treeMap;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.TREE_MAP_ADD;

public class  TreeMapAddElementTest extends TreeMapTest implements Test {

    private long result;

    public void run() {
        long timeStart = System.nanoTime();
        treeMap.put(testKey, testValue);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;
    }

    @Override
    public String getStringId() {
        return TREE_MAP_ADD;
    }

    @Override
    public long getResult() {
        return result;
    }


}
