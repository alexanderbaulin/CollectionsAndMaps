package com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.COPY_ON_WRITE_REMOVE_BEGIN;

public class CopyOnWriteRemoveElementInBeginTest extends CopyOnWriteTest implements Test {


    private long result;


    @Override
    public long run() {
        long timeStart = System.nanoTime();
        copyOnWriteArrayList.remove(0);
        long timeEnd = System.nanoTime();

        result = (timeEnd - timeStart) / 1000;
        return result;
    }

    @Override
    public String getStringId() {
        return COPY_ON_WRITE_REMOVE_BEGIN;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtCopyOnWriteRemoveBegin;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbCopyOnWriteRemoveBegin;
    }

    @Override
    public long getResult() {
        return result;
    }

}
