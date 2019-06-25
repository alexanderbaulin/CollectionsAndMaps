package com.baulin.alexander.collectionsandmaps.mvp.model.hashMap;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.HASH_MAP_REMOVE;

public class HashMapRemoveElementTest extends HashMapTest implements Test {

    private long result;

    public void run() {
        long timeStart = System.nanoTime();
        hashMap.remove(testKey);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;
    }

    @Override
    public String getStringId() {
        return HASH_MAP_REMOVE;
    }

    @Override
    public long getResult() {
        return result;
    }

}
