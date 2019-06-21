package com.baulin.alexander.collectionsandmaps.mvp.model.treeMap;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.TREE_MAP_REMOVE;

public class TreeMapRemoveElementTest extends TreeMapTest implements Test {

    private long result;

    public long run() {
        long timeStart = System.nanoTime();
        treeMap.remove(testKey);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return TREE_MAP_REMOVE;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtTreeMapRemove;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbTreeMapRemove;
    }

    @Override
    public long getResult() {
        return result;
    }
}
