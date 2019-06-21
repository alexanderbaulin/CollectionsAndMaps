package com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.COPY_ON_WRITE_BEGIN;

public class CopyOnWriteAddElementInBeginTest extends CopyOnWriteTest implements Test {

    private long result;

    @Override
    public long run() {

        long timeStart = System.nanoTime();
        copyOnWriteArrayList.add(0, testElement);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart)/1000;

        return result;
    }

    @Override
    public String getStringId() {
        return COPY_ON_WRITE_BEGIN;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtCopyOnWriteAddBegin;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbCopyOnWriteAddBegin;
    }

    @Override
    public long getResult() {
        return result;
    }

}
