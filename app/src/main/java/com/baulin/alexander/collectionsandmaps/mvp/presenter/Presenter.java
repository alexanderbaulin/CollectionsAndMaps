package com.baulin.alexander.collectionsandmaps.mvp.presenter;


import android.annotation.SuppressLint;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.dagger2.components.AppComponent;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.View;
import com.baulin.alexander.collectionsandmaps.mvp.model.Fillable;
import com.baulin.alexander.collectionsandmaps.mvp.model.Test;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class Presenter implements com.baulin.alexander.collectionsandmaps.mvp.interfaces.Presenter {
    private WeakReference<View> view;
    private int executingTests = 0;
    private int collectionTestsGroupPriority = 0;
    private int numberOfElements;

    @Inject
    Model model;

    public Presenter() {
        AppComponent component = App.getComponent();
        if(component != null) component.injectPresenter(this);
    }
     
    @Override
    public void setView(View v) {
        view = new WeakReference<>(v);
    }

    @Override
    public void onSubmitButtonClicked() {
        String number = view.get().getInputNumber();
        if(number.equals("") || number.contains("-")) {
            view.get().showToast("Enter int number >= 0");
            return;
        }
        numberOfElements = Integer.valueOf(number);
        view.get().setPostSubmitClickedUI();
        fillCollectionsAndMaps(model.getFillTasks());
    }

    @Override
    public void onFloatingCalculationButtonClicked() {
        if(view.get().isTabCollectionSelected()) {
            view.get().setCollectionTestsExecutingUI();
            executingTests +=21;
            runCollectionsTests();
        } else {
            view.get().setMapsTestsExecutingUI();
            executingTests +=6;
            runMapsTests(model.getMapsTests());
        }
    }

    public void setModel(Model m) {
        model = m;
    }

    private void fillCollectionsAndMaps(Observable<Fillable> fillTasks) {
        fillTasks
                .flatMap(CollectionOrMap ->
                        Observable.just(CollectionOrMap)
                                .subscribeOn(Schedulers.computation())
                                .map(asyncTask -> {
                                    asyncTask.fillWithElements(numberOfElements);
                                   // Log.d("rxJava", "Emitting item " + asyncTask.getClass() + " on: " + Thread.currentThread().getName());
                                    return asyncTask;
                                })
                                .observeOn(AndroidSchedulers.mainThread())
                )
                .doOnComplete(this::setPostLoadingElementsUI)
                .subscribe();

    }

    private void setPostLoadingElementsUI() {
        view.get().setPostLoadingUI();
    }

    @SuppressLint("CheckResult")
    private void runCollectionsTests(Observable<Test> tests) {
        tests.flatMap(Test ->
                Observable.just(Test)
                        .subscribeOn(Schedulers.computation())
                        .map(asyncTask -> {
                            asyncTask.run();
                            //Log.d("rxJava", "Running " + Test.getStringId() + " on: " + Thread.currentThread().getName());
                            asyncTask.getStringId();
                            return asyncTask;
                        })
                        .observeOn(AndroidSchedulers.mainThread())
        )
                .doOnComplete(this::runCollectionsTests)
                .subscribe(Test -> {
                            view.get().setCollectionsTestResult(Test.getStringId(), Test.getResult());
                            executingTests--;
                            if(executingTests == 0) view.get().setTestsPostExecutingUI();
                            //Log.d("rxJava", "Consuming item " + Test.getStringId() + " on: " + Thread.currentThread().getName());
                        }
                );
    }

    @SuppressLint("CheckResult")
    private void runMapsTests(Observable<Test> tests) {
        tests.flatMap(Test ->
                Observable.just(Test)
                        .subscribeOn(Schedulers.computation())
                        .map(asyncTask -> {
                            asyncTask.run();
                            //Log.d("rxJava", "Running " + Test.getStringId() + " on: " + Thread.currentThread().getName());
                            //asyncTask.getStringId();
                            return asyncTask;
                        })
                        .observeOn(AndroidSchedulers.mainThread())
        )
                .subscribe(Test -> {
                            view.get().setMapsTestResult(Test.getStringId(), Test.getResult());
                            executingTests--;
                            if(executingTests == 0) view.get().setTestsPostExecutingUI();
                            // Log.d("rxJava", "Consuming item " + Test.getStringId() + " on: " + Thread.currentThread().getName());
                        }
                );
    }

    private void runCollectionsTests() {
        switch (collectionTestsGroupPriority) {
            case 0:
                runCollectionsTests(model.getCollectionsTestsAddAndSearch());
                collectionTestsGroupPriority++;
                break;
            case 1:
                runCollectionsTests(model.getCollectionsTestsDeleteFromEnd());
                collectionTestsGroupPriority++;
                break;
            case 2:
                runCollectionsTests(model.getCollectionsTestsDeleteFromMiddle());
                collectionTestsGroupPriority++;
                break;
            case 3:
                runCollectionsTests(model.getCollectionsTestsDeleteFromBegin());
                collectionTestsGroupPriority++;
                break;
            default:
                collectionTestsGroupPriority = 0;
        }
    }
}
