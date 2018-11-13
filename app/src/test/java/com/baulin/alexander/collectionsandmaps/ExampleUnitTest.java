package com.baulin.alexander.collectionsandmaps;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.model.Constants;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testInput0() {
        Model model = new CollectionsAndMapsTests();
        model.setNumberOfElements(0);

        model.execute(Constants.ARRAY_LIST);
        model.execute(Constants.LINKED_LIST);
        model.execute(Constants.COPY_ARRAY_LIST);

        assertTrue(model.execute(Constants.ARRAY_ADD_BEGIN) >= 0);
        assertTrue(model.execute(Constants.ARRAY_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_ADD_END) >= 0);
        assertTrue(model.execute(Constants.ARRAY_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_END) >= 0);

        assertTrue(model.execute(Constants.LINKED_ADD_BEGIN) >= 0);
        assertTrue(model.execute(Constants.LINKED_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.LINKED_ADD_END) >= 0);
        assertTrue(model.execute(Constants.LINKED_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_END) >= 0);

        assertTrue(model.execute(Constants.COPY_ON_WRITE_BEGIN) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_ADD_MIDDLE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_ADD_END) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_SEARCH_VALUE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_BEGIN) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_MIDDLE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_END) > 0);
    }

    @Test
    public void testInput1000() {
        Model model =  new CollectionsAndMapsTests();
        model.setNumberOfElements(1000);

        model.execute(Constants.ARRAY_LIST);
        model.execute(Constants.LINKED_LIST);
        model.execute(Constants.COPY_ARRAY_LIST);

        assertTrue(model.execute(Constants.ARRAY_ADD_BEGIN) >= 0);
        assertTrue(model.execute(Constants.ARRAY_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_ADD_END) >= 0);
        assertTrue(model.execute(Constants.ARRAY_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_END) >= 0);

        assertTrue(model.execute(Constants.LINKED_ADD_BEGIN) >= 0);
        assertTrue(model.execute(Constants.LINKED_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.LINKED_ADD_END) >= 0);
        assertTrue(model.execute(Constants.LINKED_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_END) >= 0);

        assertTrue(model.execute(Constants.COPY_ON_WRITE_BEGIN) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_ADD_MIDDLE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_ADD_END) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_SEARCH_VALUE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_BEGIN) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_MIDDLE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_END) > 0);
    }


    @Test
    public void testInput10000() {
        Model model =  new CollectionsAndMapsTests();
        model.setNumberOfElements(10000);

        model.execute(Constants.ARRAY_LIST);
        model.execute(Constants.LINKED_LIST);
        model.execute(Constants.COPY_ARRAY_LIST);

        assertTrue(model.execute(Constants.ARRAY_ADD_BEGIN) >= 0);
        assertTrue(model.execute(Constants.ARRAY_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_ADD_END) >= 0);
        assertTrue(model.execute(Constants.ARRAY_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.ARRAY_REMOVE_END) >= 0);

        assertTrue(model.execute(Constants.LINKED_ADD_BEGIN) >= 0);
        assertTrue(model.execute(Constants.LINKED_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.LINKED_ADD_END) >= 0);
        assertTrue(model.execute(Constants.LINKED_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(Constants.LINKED_REMOVE_END) >= 0);

        assertTrue(model.execute(Constants.COPY_ON_WRITE_BEGIN) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_ADD_MIDDLE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_ADD_END) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_SEARCH_VALUE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_BEGIN) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_MIDDLE) > 0);
        assertTrue(model.execute(Constants.COPY_ON_WRITE_REMOVE_END) > 0);
    }
}