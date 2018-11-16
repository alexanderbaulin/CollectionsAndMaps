package com.baulin.alexander.collectionsandmaps;



import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    private MainActivity activity;
    @Mock
    private CollectionsAndMapsTests tests;
    private Presenter presenter;

    private String[] mapsAsyncTasks = {
            HASH_MAP_ADD,
            HASH_MAP_SEARCH,
            HASH_MAP_REMOVE,

            TREE_MAP_ADD,
            TREE_MAP_SEARCH,
            TREE_MAP_REMOVE
    };

    private String[] collectionsAsyncTasks = {
            ARRAY_ADD_BEGIN,
            ARRAY_ADD_MIDDLE,
            ARRAY_ADD_END,
            ARRAY_SEARCH_VALUE,
            ARRAY_REMOVE_BEGIN,
            ARRAY_REMOVE_MIDDLE,
            ARRAY_REMOVE_END,

            LINKED_ADD_BEGIN,
            LINKED_ADD_MIDDLE,
            LINKED_ADD_END,
            LINKED_SEARCH_VALUE,
            LINKED_REMOVE_BEGIN,
            LINKED_REMOVE_MIDDLE,
            LINKED_REMOVE_END,

            COPY_ON_WRITE_BEGIN,
            COPY_ON_WRITE_ADD_MIDDLE,
            COPY_ON_WRITE_ADD_END,
            COPY_ON_WRITE_SEARCH_VALUE,
            COPY_ON_WRITE_REMOVE_BEGIN,
            COPY_ON_WRITE_REMOVE_MIDDLE,
            COPY_ON_WRITE_REMOVE_END
    };

    @Before
    public void init() {
        presenter = new Presenter();
        presenter.setModel(tests);
        presenter.setView(activity);

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

        when(activity.getInputNumber()).thenReturn("1");
        when(tests.getFillTasks()).thenReturn(Observable.just(ARRAY_LIST, LINKED_LIST, HASH_MAP, TREE_MAP, COPY_ARRAY_LIST));
        when(tests.getMapsTests()).thenReturn(Observable.fromArray(mapsAsyncTasks));
        when(tests.getCollectionsTests()).thenReturn(Observable.fromArray(collectionsAsyncTasks));


    }

    @Test
    public void showActivityErrorToastWhenInputNumberIsEmpty() {
        when(activity.getInputNumber()).thenReturn("");
        presenter.onSubmitButtonClicked();
        verify(activity).showToast("Enter number");
        verify(activity, never()).setPostSubmitClickedUI();
        verify(tests, never()).setNumberOfElements(Mockito.anyInt());
        verify(tests, never()).getFillTasks();
    }

    @Test
    public void updateActivityUserInterface() {
        presenter.onSubmitButtonClicked();
        verify(activity).setPostSubmitClickedUI();
    }

    @Test
    public void setTestsNumberOfElements() {
        when(activity.getInputNumber()).thenReturn("1");
        presenter.onSubmitButtonClicked();
        verify(tests).setNumberOfElements(1);
    }

    @Test
    public void runCollectionsFill() {
        presenter.onSubmitButtonClicked();
        verify(tests).getFillTasks();
    }

    @Test
    public void runMapsTests() {
        when(activity.isTabCollectionSelected()).thenReturn(false);
        presenter.onSubmitButtonClicked();
        presenter.onFloatingCalculationButtonClicked();
        verify(activity).setMapsTestsExecutingUI();
        verify(activity, never()).setCollectionTestsExecutingUI();
        verify(tests).getMapsTests();
        verify(tests, never()).getCollectionsTests();

    }

    @Test
    public void runCollectionsTests() {
        when(activity.isTabCollectionSelected()).thenReturn(true);
        presenter.onSubmitButtonClicked();
        presenter.onFloatingCalculationButtonClicked();
        verify(activity).setCollectionTestsExecutingUI();
        verify(activity, never()).setMapsTestsExecutingUI();
        verify(tests).getCollectionsTests();
        verify(tests, never()).getMapsTests();
    }


}

