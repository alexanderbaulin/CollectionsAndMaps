package com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList;

import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.COPY_ON_WRITE_REMOVE_END;

public class CopyOnWriteRemoveElementInEndTest extends CopyOnWriteTest implements Test {


    private long result;


    @Override
    public void run() {
        long timeStart = System.nanoTime();
        copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart) / 1000;
    }

    @Override
    public String getStringId() {
        return COPY_ON_WRITE_REMOVE_END;
    }

    @Override
    public long getResult() {
        return result;
    }
}
