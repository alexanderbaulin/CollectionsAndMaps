package com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.COPY_ON_WRITE_REMOVE_END;

public class CopyOnWriteRemoveElementInEndTest extends CopyOnWriteTest implements Test {


    private long result;


    @Override
    public long run() {
        if(copyOnWriteArrayList.size() != 0) {

            long timeStart = System.nanoTime();
            copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
            long timeEnd = System.nanoTime();

            result = (timeEnd - timeStart) / 1000;

            return result;
        }
        return 0;
    }

    @Override
    public String getStringId() {
        return COPY_ON_WRITE_REMOVE_END;
    }

    @Override
    public int getTxtViewID() {
        return R.id.txtCopyOnWriteRemoveEnd;
    }

    @Override
    public int getPbViewID() {
        return R.id.pbCopyOnWriteRemoveEnd;
    }

    @Override
    public long getResult() {
        return result;
    }
}
