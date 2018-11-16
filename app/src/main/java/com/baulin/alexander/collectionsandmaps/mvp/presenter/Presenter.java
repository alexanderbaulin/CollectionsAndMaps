package com.baulin.alexander.collectionsandmaps.mvp.presenter;


import android.util.Log;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.dagger2.components.AppComponent;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.View;

import java.lang.ref.WeakReference;
import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static android.view.View.*;
import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;



public class Presenter implements com.baulin.alexander.collectionsandmaps.mvp.interfaces.Presenter {
    private WeakReference<View> view;
    private TreeMap<String, Integer> textViews = new TreeMap<>();
    private TreeMap<String, Integer> pbBars = new TreeMap<>();
    private TreeMap<String, Long> testResults = new TreeMap<>();
    private int executingCollectionsTests = 0;

    @Inject
    Model model;

    public Presenter() {
        //App.getComponent().injectPresenter(this);
        AppComponent component = App.getComponent();
        if(component != null) component.injectPresenter(this);

        textViews.put(ARRAY_ADD_BEGIN, R.id.txtArrayAddBegin);
        pbBars.put(ARRAY_ADD_BEGIN, R.id.pbArrayAddBegin);

        textViews.put(ARRAY_ADD_MIDDLE, R.id.txtArrayAddMiddle);
        pbBars.put(ARRAY_ADD_MIDDLE, R.id.pbArrayAddMiddle);

        textViews.put(ARRAY_ADD_END, R.id.txtArrayAddEnd);
        pbBars.put(ARRAY_ADD_END, R.id.pbArrayAddEnd);

        textViews.put(ARRAY_SEARCH_VALUE, R.id.txtArraySearchValue);
        pbBars.put(ARRAY_SEARCH_VALUE, R.id.pbArraySearchValue);

        textViews.put(ARRAY_REMOVE_BEGIN, R.id.txtArrayRemoveBegin);
        pbBars.put(ARRAY_REMOVE_BEGIN, R.id.pbArrayRemoveBegin);

        textViews.put(ARRAY_REMOVE_MIDDLE, R.id.txtArrayRemoveMiddle);
        pbBars.put(ARRAY_REMOVE_MIDDLE, R.id.pbArrayRemoveMiddle);

        textViews.put(ARRAY_REMOVE_END, R.id.txtArrayRemoveEnd);
        pbBars.put(ARRAY_REMOVE_END, R.id.pbArrayRemoveEnd);

        textViews.put(LINKED_ADD_BEGIN, R.id.txtLinkedAddBegin);
        pbBars.put(LINKED_ADD_BEGIN,  R.id.pbLinkedAddBegin);

        textViews.put(LINKED_ADD_MIDDLE, R.id.txtLinkedAddMiddle);
        pbBars.put(LINKED_ADD_MIDDLE, R.id.pbLinkedAddMiddle);

        textViews.put(LINKED_ADD_END, R.id.txtLinkedAddEnd);
        pbBars.put(LINKED_ADD_END, R.id.pbLinkedAddEnd);

        textViews.put(LINKED_SEARCH_VALUE, R.id.txtLinkedSearchValue);
        pbBars.put(LINKED_SEARCH_VALUE, R.id.pbLinkedSearchValue);

        textViews.put(LINKED_REMOVE_BEGIN, R.id.txtLinkedRemoveBegin);
        pbBars.put(LINKED_REMOVE_BEGIN, R.id.pbLinkedRemoveBegin);

        textViews.put(LINKED_REMOVE_MIDDLE, R.id.txtLinkedRemoveMiddle);
        pbBars.put(LINKED_REMOVE_MIDDLE, R.id.pbLinkedRemoveMiddle);


        textViews.put(LINKED_REMOVE_END, R.id.txtLinkedRemoveEnd);
        pbBars.put(LINKED_REMOVE_END, R.id.pbLinkedRemoveEnd);

        textViews.put(COPY_ON_WRITE_BEGIN, R.id.txtCopyOnWriteAddBegin);
        pbBars.put(COPY_ON_WRITE_BEGIN, R.id.pbCopyOnWriteAddBegin);

        textViews.put(COPY_ON_WRITE_ADD_MIDDLE, R.id.txtCopyOnWriteAddMiddle);
        pbBars.put(COPY_ON_WRITE_ADD_MIDDLE, R.id.pbCopyOnWriteAddMiddle);

        textViews.put(COPY_ON_WRITE_ADD_END, R.id.txtCopyOnWriteAddEnd);
        pbBars.put(COPY_ON_WRITE_ADD_END, R.id.pbCopyOnWriteAddEnd);

        textViews.put(COPY_ON_WRITE_SEARCH_VALUE, R.id.txtCopyOnWriteSearchValue);
        pbBars.put(COPY_ON_WRITE_SEARCH_VALUE, R.id.pbCopyOnWriteSearchValue);

        textViews.put(COPY_ON_WRITE_REMOVE_BEGIN, R.id.txtCopyOnWriteRemoveBegin);
        pbBars.put(COPY_ON_WRITE_REMOVE_BEGIN, R.id.pbCopyOnWriteRemoveBegin);

        textViews.put(COPY_ON_WRITE_REMOVE_MIDDLE, R.id.txtCopyOnWriteRemoveMiddle);
        pbBars.put(COPY_ON_WRITE_REMOVE_MIDDLE, R.id.pbCopyOnWriteRemoveMiddle);

        textViews.put(COPY_ON_WRITE_REMOVE_END, R.id.txtCopyOnWriteRemoveEnd);
        pbBars.put(COPY_ON_WRITE_REMOVE_END, R.id.pbCopyOnWriteRemoveEnd);




        textViews.put(HASH_MAP_ADD, R.id.txtHashMapAdd);
        pbBars.put(HASH_MAP_ADD, R.id.pbHashMapAdd);

        textViews.put(HASH_MAP_SEARCH, R.id.txtHashMapSearch);
        pbBars.put(HASH_MAP_SEARCH, R.id.pbHashMapSearch);

        textViews.put(HASH_MAP_REMOVE, R.id.txtHashMapRemove);
        pbBars.put(HASH_MAP_REMOVE, R.id.pbHashMapRemove);

        textViews.put(TREE_MAP_ADD, R.id.txtTreeMapAdd);
        pbBars.put(TREE_MAP_ADD, R.id.pbTreeMapAdd);

        textViews.put(TREE_MAP_SEARCH, R.id.txtTreeMapSearch);
        pbBars.put(TREE_MAP_SEARCH, R.id.pbTreeMapSearch);

        textViews.put(TREE_MAP_REMOVE, R.id.txtTreeMapRemove);
        pbBars.put(TREE_MAP_REMOVE, R.id.pbTreeMapRemove);

    }
     
    @Override
    public void setView(View v) {
        view = new WeakReference<>(v);
    }

    @Override
    public void onSubmitButtonClicked() {
        String number = view.get().getInputNumber();
        if(number.equals("")) {
            view.get().showToast("Enter number");
            return;
        }
        model.setNumberOfElements(Integer.valueOf(number));
       // Log.d("myLogs5", "button " + Integer.valueOf(number));
        view.get().setPostSubmitClickedUI();
        fillCollectionsAndMaps();
    }

    @Override
    public void onFloatingCalculationButtonClicked() {
        if(view.get().isTabCollectionSelected()) {
            view.get().setCollectionTestsExecutingUI();
            executingCollectionsTests +=21;
            runTests(model.getCollectionsTests());
        } else {
            view.get().setMapsTestsExecutingUI();
            executingCollectionsTests +=6;
            runTests(model.getMapsTests());
        }
    }

    public void setModel(Model m) {
        model = m;
    }

    private void fillCollectionsAndMaps() {
        model.getFillTasks()
                .flatMap(String ->
                Observable.just(String)
                        .subscribeOn(Schedulers.computation())
                        .map(task -> {
                            model.execute(String);
                           // Log.d("rxJava", "Emitting item " + String + " on: " + Thread.currentThread().getName());
                            return task;
                        })
                        .observeOn(AndroidSchedulers.mainThread())
        )
                .subscribe(String -> {
                        if (String.compareToIgnoreCase("copyArrayList") == 0)
                        view.get().setPostLoadingUI();
                         //Log.d("rxJava", "Consuming item " + String + " on: " + Thread.currentThread().getName());
                        }
                );

    }


    private void runTests(Observable<String> test) {
        test.flatMap(String ->
                Observable.defer(() -> Observable.just(String))
                        .subscribeOn(Schedulers.computation())
                        .map(task -> {
                            long timeTaskExecution = model.execute(task);
                            testResults.put(task, timeTaskExecution);
                            return task;
                        })
                        .observeOn(AndroidSchedulers.mainThread())
        )
                .subscribe(String -> {
                            int txtID = textViews.get(String);
                            int pbID = pbBars.get(String);
                            long timeTaskExecution = testResults.get(String);
                            view.get().setTestResult(txtID, String.valueOf(timeTaskExecution));
                            view.get().setProgressIndicator(pbID, INVISIBLE);
                            executingCollectionsTests--;
                            if(executingCollectionsTests == 0) view.get().setTestsPostExecutingUI();
                            //Log.d("rxJava", "Consuming item " + String + " on: " + Thread.currentThread().getName());
                        }
                );
    }
}
