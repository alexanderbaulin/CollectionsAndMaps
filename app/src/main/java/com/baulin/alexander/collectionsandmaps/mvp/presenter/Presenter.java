package com.baulin.alexander.collectionsandmaps.mvp.presenter;


import android.util.Log;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.View;
import com.baulin.alexander.collectionsandmaps.mvp.model.TestTask;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.view.View.*;
import static com.baulin.alexander.collectionsandmaps.mvp.model.Constants.*;



public class Presenter implements com.baulin.alexander.collectionsandmaps.mvp.interfaces.Presenter {
    private WeakReference<View> view;
    private TreeMap<String, Integer> textViews = new TreeMap<>();
    private TreeMap<String, Integer> pbBars = new TreeMap<>();
    private TreeMap<String, Long> testResults = new TreeMap<>();

    @Inject
    Model model;

    public Presenter() {
        App.getComponent().injectPresenter(this);

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
        Log.d("myLogs5", "button " + Integer.valueOf(number));
        view.get().setPostSubmitClickedUI();
        fillCollectionsAndMaps();
    }

    @Override
    public void onFloatingCalculationButtonClicked() {
        if(view.get().isTabCollectionSelected()) {
           // view.get().setCollectionTestsExecutingUI();
           // runTests(model.getCollectionsTests());
        } else {
            view.get().setMapsTestsExecutingUI();
            runTests(model.getMapsTests());
        }
    }

    private void fillCollectionsAndMaps() {
        model.getFillTasks()
                .doOnNext(String -> {
                            model.execute(String);
                            Log.d("rxJava", "Emitting item " + String + " on: " + Thread.currentThread().getName());
                        }
                )
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(String -> {
                            if(String.compareToIgnoreCase("copyArrayList") == 0) view.get().setPostLoadingUI();
                            Log.d("rxJava", "Consuming item " + String + " on: " + Thread.currentThread().getName());
                        }
                );
    }


    private void runTests(Observable<String> test) {
        test.flatMap(String ->
                Observable.just(String)
                .subscribeOn(Schedulers.computation())
                .map(i -> execute(String))
                .observeOn(AndroidSchedulers.mainThread())
        )
                .subscribe(String -> {
                            int txtID = textViews.get(String);
                            int pbID = pbBars.get(String);
                            long timeTaskExecution = testResults.get(String);
                            view.get().setTestResult(txtID, String.valueOf(timeTaskExecution));
                            view.get().setProgressIndicator(pbID, INVISIBLE);
                            Log.d("rxJava", "Consuming item " + String + " on: " + Thread.currentThread().getName());
                        }
                );
    }

    private String execute(String task) {
         long timeTaskExecution = model.execute(task);
         testResults.put(task, timeTaskExecution);
         return task;
    }

}
