package com.baulin.alexander.collectionsandmaps.dagger2.components;


import android.content.Context;


import com.baulin.alexander.collectionsandmaps.dagger2.modules.ContextModule;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;


import dagger.Component;


@ApplicationScope
@Component(modules = { ContextModule.class})
public interface AppComponent {
    Model getTests();
    Context getContext();
    void injectPresenter(Presenter presenter);
}
