package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import android.content.Context;

import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context ctx) {
        context = ctx;
    }

    @Provides
    @ApplicationScope
    public Context context() {
        return context;
    }
}