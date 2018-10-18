package com.baulin.alexander.collectionsandmaps.dagger2;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.baulin.alexander.collectionsandmaps.dagger2.components.*;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.ContextModule;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;


public class App extends Application {

    private Presenter presenter;
    private MainActivity mainActivity;

    public static App get(Activity activity) {
        return (App)activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent component = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        presenter = component.getPresenter();
        mainActivity = component.getMainActivity();
        Log.d("dagger", component.getPresenter().toString());
        Log.d("dagger", component.getPresenter().toString());
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public MainActivity getActivity() {
        return mainActivity;
    }
}
