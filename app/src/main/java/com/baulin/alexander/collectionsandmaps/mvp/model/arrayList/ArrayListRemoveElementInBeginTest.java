package com.baulin.alexander.collectionsandmaps.mvp.model.arrayList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.ARRAY_REMOVE_BEGIN;

public class ArrayListRemoveElementInBeginTest extends ArrayListTest implements Test {

    private long result;


    @Override
    public long run() {

        long timeStart = System.nanoTime();
        arrayList.remove(0);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart) / 1000;
        return result;

    }

    @Override
    public String getStringId() {
        return ARRAY_REMOVE_BEGIN;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtArrayRemoveBegin;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbArrayRemoveBegin;
    }

    @Override
    public long getResult() {
        return result;
    }
}
