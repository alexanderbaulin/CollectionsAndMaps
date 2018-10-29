package com.baulin.alexander.collectionsandmaps.dagger2.components;


import com.baulin.alexander.collectionsandmaps.dagger2.modules.AppModule;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;


import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = { AppModule.class})
public interface AppComponent {
    void injectPresenter(Presenter presenter);
    void injectTests(CollectionsAndMapsTests tests);
}
