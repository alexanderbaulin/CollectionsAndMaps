package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import android.content.Context;

import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context ctx) {
        context = ctx;
    }

    @Provides
    @Singleton
    Model tests() {
        return new CollectionsAndMapsTests();
    }

    @Provides
    @Singleton
    Context context() {
        return context;
    }

}
