package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.MainActivityScope;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity activity) {
        mainActivity = activity;
    }

    @Provides
    @MainActivityScope
    MainActivity mainActivity() {
        return mainActivity;
    }
}