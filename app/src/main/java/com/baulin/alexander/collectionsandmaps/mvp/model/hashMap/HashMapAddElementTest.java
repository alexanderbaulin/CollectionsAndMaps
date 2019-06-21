package com.baulin.alexander.collectionsandmaps.mvp.model.hashMap;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.HASH_MAP_ADD;

public class HashMapAddElementTest extends HashMapTest implements Test {

    private long result;

    public long run() {
        long timeStart = System.nanoTime();
        hashMap.put(testKey, testValue);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return HASH_MAP_ADD;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtHashMapAdd;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbHashMapAdd;
    }

    @Override
    public long getResult() {
        return result;
    }
}
