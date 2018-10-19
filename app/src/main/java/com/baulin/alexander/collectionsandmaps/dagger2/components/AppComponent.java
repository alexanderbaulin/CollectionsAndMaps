package com.baulin.alexander.collectionsandmaps.dagger2.components;


import android.content.Context;

import com.baulin.alexander.collectionsandmaps.TestClass;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.AppModule;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;


import dagger.Component;


@ApplicationScope
@Component(modules = { AppModule.class})
public interface AppComponent {
    Model getTests(); // этот метод НЕЛЬЗЯ убарть не получив ошибки
    //TestClass getTestClass(); этот метод можно убрать закомментив
    void injectPresenter(Presenter presenter);
    void injectTests(CollectionsAndMapsTests tests);
}
