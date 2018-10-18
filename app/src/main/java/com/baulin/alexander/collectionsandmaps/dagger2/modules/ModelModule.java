package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {

    @Provides
    @ApplicationScope
    CollectionsAndMapsTests tests() {
        return new CollectionsAndMapsTests();
    }
}
