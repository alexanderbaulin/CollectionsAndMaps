package com.baulin.alexander.collectionsandmaps.dagger2;

import android.app.Activity;
import android.app.Application;

import com.baulin.alexander.collectionsandmaps.dagger2.components.*;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.AppModule;


public class App extends Application {

    static AppComponent component;

    public static App get(Activity activity) {
        return (App)activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();


        //presenter = component.getPresenter();

        //Log.d("dagger", component.getPresenter().toString());
        //Log.d("dagger", component.getPresenter().toString());
    }

    public static AppComponent getComponent() {
        return component;
    }
}
