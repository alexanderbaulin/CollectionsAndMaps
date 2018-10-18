package com.baulin.alexander.collectionsandmaps.dagger2.modules;


import com.baulin.alexander.collectionsandmaps.dagger2.scopes.ApplicationScope;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = UI_Module.class)
public class PresenterModule {

    @Provides
    @ApplicationScope
    Presenter presenter(MainActivity activity) {
        return new Presenter(activity);
    }
}
