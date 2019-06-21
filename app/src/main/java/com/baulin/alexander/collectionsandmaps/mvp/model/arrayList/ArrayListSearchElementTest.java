package com.baulin.alexander.collectionsandmaps.mvp.model.arrayList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.ARRAY_SEARCH_VALUE;

public class ArrayListSearchElementTest extends ArrayListTest implements Test {

    private long result;

    @Override
    public long run() {
        long timeStart = System.nanoTime();
        arrayList.indexOf(arrayList.size()/2);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return ARRAY_SEARCH_VALUE;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtArraySearchValue;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbArraySearchValue;
    }

    @Override
    public long getResult() {
        return result;
    }

}
