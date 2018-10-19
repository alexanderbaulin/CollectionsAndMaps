package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.dagger2.scopes.MainActivityScope;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = MainActivityModule.class)
public class PresenterModule {

    @Provides
    @MainActivityScope
    Presenter presenter(MainActivity activity) {
        return new Presenter(activity);
    }
}
