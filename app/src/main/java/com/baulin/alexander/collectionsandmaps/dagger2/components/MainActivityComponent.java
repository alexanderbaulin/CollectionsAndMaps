package com.baulin.alexander.collectionsandmaps.dagger2.components;

import com.baulin.alexander.collectionsandmaps.dagger2.modules.MainActivityModule;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.PresenterModule;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.MainActivityScope;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import dagger.Component;


@MainActivityScope
@Component(modules = { MainActivityModule.class,  PresenterModule.class }, dependencies = AppComponent.class)
public interface MainActivityComponent {
    Presenter getPresenter();
    MainActivity getMainActivity();
    CollectionsAndMapsTests getTests();
}
