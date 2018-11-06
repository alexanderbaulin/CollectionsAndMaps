package com.baulin.alexander.collectionsandmaps.mvp.presenter;


import android.util.Log;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.View;
import com.baulin.alexander.collectionsandmaps.mvp.model.TestTask;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.view.View.*;


public class Presenter implements com.baulin.alexander.collectionsandmaps.mvp.interfaces.Presenter {
    private WeakReference<View> view;

    @Inject
    Model model;

    public Presenter() {
        App.getComponent().injectPresenter(this);
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
            view.get().setCollectionTestsExecutingUI();
            runTests(model.getCollectionsTests());
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

    private void runTests(ArrayList<Observable<TestTask>> tests) {
        for(Observable<TestTask> test: tests) {
            test.doOnNext(TestTask -> {
                        long timeTaskExecution = model.execute(TestTask.getName());
                        TestTask.setTime(timeTaskExecution);
                        Log.d("rxJava", "Emitting item " + TestTask.getName() + " on: " + Thread.currentThread().getName());
                    }
            )
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(TestTask -> {
                                int txtID = TestTask.getTxtID();
                                int pbID = TestTask.getPbID();
                                view.get().setTestResult(txtID, String.valueOf(TestTask.getTime()));
                                view.get().setProgressIndicator(pbID, INVISIBLE);
                                Log.d("rxJava", "Consuming item " + TestTask.getName() + " on: " + Thread.currentThread().getName());
                            }
                    );
        }
    }
}
