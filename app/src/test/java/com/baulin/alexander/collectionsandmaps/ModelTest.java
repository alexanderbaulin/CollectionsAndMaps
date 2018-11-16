package com.baulin.alexander.collectionsandmaps;


import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;


import org.junit.Test;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;
import static org.junit.Assert.*;

/**
 * Example local unit showActivityErrorToastWhenInputNumberIsEmpty, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ModelTest {

    @Test
    public void testInput0() {
        Model model = new CollectionsAndMapsTests();
        model.setNumberOfElements(0);

        model.execute(ARRAY_LIST);
        model.execute(LINKED_LIST);
        model.execute(COPY_ARRAY_LIST);
        model.execute(TREE_MAP);
        model.execute(HASH_MAP);

        assertTrue(model.execute(ARRAY_ADD_BEGIN) >= 0);
        assertTrue(model.execute(ARRAY_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(ARRAY_ADD_END) >= 0);
        assertTrue(model.execute(ARRAY_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_END) >= 0);

        assertTrue(model.execute(LINKED_ADD_BEGIN) >= 0);
        assertTrue(model.execute(LINKED_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(LINKED_ADD_END) >= 0);
        assertTrue(model.execute(LINKED_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_END) >= 0);

        assertTrue(model.execute(COPY_ON_WRITE_BEGIN) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_ADD_MIDDLE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_ADD_END) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_SEARCH_VALUE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_BEGIN) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_MIDDLE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_END) > 0);

        assertTrue(model.execute(TREE_MAP_ADD) >= 0);
        assertTrue(model.execute(TREE_MAP_SEARCH) >= 0);
        assertTrue(model.execute(TREE_MAP_REMOVE) >= 0);

        assertTrue(model.execute(HASH_MAP_ADD) >= 0);
        assertTrue(model.execute(HASH_MAP_SEARCH) >= 0);
        assertTrue(model.execute(HASH_MAP_REMOVE) >= 0);

    }

    @Test
    public void testInput1000() {
        Model model =  new CollectionsAndMapsTests();
        model.setNumberOfElements(1000);

        model.execute(ARRAY_LIST);
        model.execute(LINKED_LIST);
        model.execute(COPY_ARRAY_LIST);
        model.execute(TREE_MAP);
        model.execute(HASH_MAP);

        assertTrue(model.execute(ARRAY_ADD_BEGIN) >= 0);
        assertTrue(model.execute(ARRAY_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(ARRAY_ADD_END) >= 0);
        assertTrue(model.execute(ARRAY_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_END) >= 0);

        assertTrue(model.execute(LINKED_ADD_BEGIN) >= 0);
        assertTrue(model.execute(LINKED_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(LINKED_ADD_END) >= 0);
        assertTrue(model.execute(LINKED_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_END) >= 0);

        assertTrue(model.execute(COPY_ON_WRITE_BEGIN) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_ADD_MIDDLE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_ADD_END) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_SEARCH_VALUE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_BEGIN) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_MIDDLE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_END) > 0);

        assertTrue(model.execute(TREE_MAP_ADD) >= 0);
        assertTrue(model.execute(TREE_MAP_SEARCH) >= 0);
        assertTrue(model.execute(TREE_MAP_REMOVE) >= 0);

        assertTrue(model.execute(HASH_MAP_ADD) >= 0);
        assertTrue(model.execute(HASH_MAP_SEARCH) >= 0);
        assertTrue(model.execute(HASH_MAP_REMOVE) >= 0);
    }


    @Test
    public void testInput10000() {
        Model model =  new CollectionsAndMapsTests();
        model.setNumberOfElements(10000);

        model.execute(ARRAY_LIST);
        model.execute(LINKED_LIST);
        model.execute(COPY_ARRAY_LIST);
        model.execute(TREE_MAP);
        model.execute(HASH_MAP);

        assertTrue(model.execute(ARRAY_ADD_BEGIN) >= 0);
        assertTrue(model.execute(ARRAY_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(ARRAY_ADD_END) >= 0);
        assertTrue(model.execute(ARRAY_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(ARRAY_REMOVE_END) >= 0);

        assertTrue(model.execute(LINKED_ADD_BEGIN) >= 0);
        assertTrue(model.execute(LINKED_ADD_MIDDLE) >= 0);
        assertTrue(model.execute(LINKED_ADD_END) >= 0);
        assertTrue(model.execute(LINKED_SEARCH_VALUE) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_BEGIN) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_MIDDLE) >= 0);
        assertTrue(model.execute(LINKED_REMOVE_END) >= 0);

        assertTrue(model.execute(COPY_ON_WRITE_BEGIN) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_ADD_MIDDLE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_ADD_END) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_SEARCH_VALUE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_BEGIN) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_MIDDLE) > 0);
        assertTrue(model.execute(COPY_ON_WRITE_REMOVE_END) > 0);

        assertTrue(model.execute(TREE_MAP_ADD) >= 0);
        assertTrue(model.execute(TREE_MAP_SEARCH) >= 0);
        assertTrue(model.execute(TREE_MAP_REMOVE) >= 0);

        assertTrue(model.execute(HASH_MAP_ADD) >= 0);
        assertTrue(model.execute(HASH_MAP_SEARCH) >= 0);
        assertTrue(model.execute(HASH_MAP_REMOVE) >= 0);
    }
}