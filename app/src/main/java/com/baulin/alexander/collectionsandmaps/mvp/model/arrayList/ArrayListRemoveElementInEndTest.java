package com.baulin.alexander.collectionsandmaps.mvp.model.arrayList;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.ARRAY_REMOVE_END;

public class ArrayListRemoveElementInEndTest extends ArrayListTest implements Test {

    private long result;

    @Override
    public void run() {
        long timeStart = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart) / 1000;
    }

    @Override
    public String getStringId() {
        return ARRAY_REMOVE_END;
    }

    @Override
    public long getResult() {
        return result;
    }
}
