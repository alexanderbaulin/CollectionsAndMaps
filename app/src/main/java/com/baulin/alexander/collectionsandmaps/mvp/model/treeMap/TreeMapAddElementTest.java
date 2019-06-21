package com.baulin.alexander.collectionsandmaps.mvp.model.treeMap;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.TREE_MAP_ADD;

public class  TreeMapAddElementTest extends TreeMapTest implements Test {

    private long result;

    public long run() {
        long timeStart = System.nanoTime();
        treeMap.put(testKey, testValue);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return TREE_MAP_ADD;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtTreeMapAdd;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbTreeMapAdd;
    }

    @Override
    public long getResult() {
        return result;
    }


}
