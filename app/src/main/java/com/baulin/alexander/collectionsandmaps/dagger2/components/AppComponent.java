package com.baulin.alexander.collectionsandmaps.dagger2.components;


import android.content.Context;


import com.baulin.alexander.collectionsandmaps.dagger2.modules.ContextModule;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.ModelModule;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;

import dagger.Component;


@ApplicationScope
@Component(modules = { ModelModule.class, ContextModule.class})
public interface AppComponent {
    CollectionsAndMapsTests getTests();
    Context getContext();
}
