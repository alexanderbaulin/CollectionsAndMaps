package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import android.content.Context;

import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.CollectionsAndMapsTests;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context ctx) {
        context = ctx;
    }

    @Provides
    @ApplicationScope
    Model tests() {
        return new CollectionsAndMapsTests();
    }

    @Provides
    @ApplicationScope
    Context context() {
        return context;
    }

}
