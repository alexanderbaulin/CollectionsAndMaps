package com.baulin.alexander.collectionsandmaps.mvp.model.arrayList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.ARRAY_ADD_END;

public class ArrayListAddElementInEndTest extends ArrayListTest implements Test {

    private long result;


    @Override
    public long run() {
        long timeStart = System.nanoTime();
        arrayList.add(testElement);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return ARRAY_ADD_END;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtArrayAddEnd;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbArrayAddEnd;
    }

    @Override
    public long getResult() {
        return result;
    }

}
