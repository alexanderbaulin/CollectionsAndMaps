package com.baulin.alexander.collectionsandmaps;

import android.app.Application;
import android.util.Log;

import com.baulin.alexander.collectionsandmaps.dagger2.components.*;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.ContextModule;


public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent component = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        Log.d("dagger", component.getPresenter().toString());
        Log.d("dagger", component.getPresenter().toString());



    }
}
