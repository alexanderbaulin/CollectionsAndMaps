package com.baulin.alexander.collectionsandmaps.mvp.model.hashMap;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.HASH_MAP_SEARCH;

public class HashMapSearchElementTest extends HashMapTest implements Test {

    private long result;

    public long run() {
        long timeStart = System.nanoTime();
        hashMap.get(testKey);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return HASH_MAP_SEARCH;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtHashMapSearch;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbHashMapSearch;
    }

    @Override
    public long getResult() {
        return result;
    }

}
