package com.baulin.alexander.collectionsandmaps.dagger2.components;


import android.content.Context;


import com.baulin.alexander.collectionsandmaps.dagger2.modules.ContextModule;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.ModelModule;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.PresenterModule;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import dagger.Component;


@ApplicationScope
@Component(modules = { PresenterModule.class, ModelModule.class, ContextModule.class})
public interface AppComponent {
    Presenter getPresenter();
    MainActivity getMainActivity();
    CollectionsAndMapsTests getTests();
    Context getContext();
}
