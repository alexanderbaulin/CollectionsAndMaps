package com.baulin.alexander.collectionsandmaps.mvp.ui;



import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.dagger2.components.DaggerMainActivityComponent;
import com.baulin.alexander.collectionsandmaps.dagger2.components.MainActivityComponent;
import com.baulin.alexander.collectionsandmaps.dagger2.modules.MainActivityModule;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity implements com.baulin.alexander.collectionsandmaps.mvp.interfaces.View {
    CollectionsFragment collectionsFragment;
    MapsFragment mapsFragment;
    SectionsPageAdapter pageAdapter;

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.container) ViewPager viewPager;
    @BindView(R.id.btnFloatingAction) FloatingActionButton floatingActionButton;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.btnSubmit) Button submit;
    @BindView(R.id.editNumber) EditText input;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("myLogs", "onCreate");

        ButterKnife.bind(this);

        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .appComponent(App.getComponent())
                .build();

        component.injectMainActivity(this);
        presenter.setView(this);
        pageAdapter = new SectionsPageAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setPreSubmitClickedUI();

        if(mapsFragment != null) Log.d("rotate_crush", "Фрагмент при создании Activity " + mapsFragment.toString());

        if(savedInstanceState == null) {
            fixScreenOrientation(true);
            Log.d("test", "saveInstanceState = null");
        }
        //AndroidInjection.inject(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onClickSubmitButton(View view) {
        presenter.onSubmitButtonClicked();
    }

    @OnClick(R.id.btnFloatingAction)
    public void onClickFloatingActionButton(View view) {
        presenter.onFloatingCalculationButtonClicked();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("restore", "restore");
        setPostSubmitClickedUI();
        setPostLoadingUI();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isTabCollectionSelected() {
        Log.d("test", "item = " + viewPager.getCurrentItem()) ;
        TabLayout.Tab tabCollection = tabLayout.getTabAt(0);
        return tabCollection != null && tabCollection.isSelected();
    }

    @Override
    public String getInputNumber() {
        return input.getText().toString().trim();
    }

    @Override
    public void setPreSubmitClickedUI() {
        input.setVisibility(VISIBLE);
        submit.setVisibility(VISIBLE);
        progressBar.setVisibility(INVISIBLE);
        viewPager.setVisibility(INVISIBLE);
    }

    @Override
    public void setPostSubmitClickedUI() {
        input.setVisibility(INVISIBLE);
        submit.setVisibility(INVISIBLE);
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void setPostLoadingUI() {
        progressBar.setVisibility(GONE);
        viewPager.setVisibility(VISIBLE);
        floatingActionButton.setVisibility(VISIBLE);
        fixScreenOrientation(false);
    }

    @Override
    public void setProgressIndicator(int pbID, int visibility) {
        getProgressBar(pbID).setVisibility(visibility);
    }

    @Override
    public void setTestResult(int txtID, String result) {
        getTextView(txtID).setText(result);
    }

    private void fixScreenOrientation(boolean fixScreen) {
        if(fixScreen) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
    }

    private ProgressBar getProgressBar(int id) {
        Log.d("rotate_crush", "Обращение к фрагменту из Activity за ProgressBar" + mapsFragment.toString());
        ProgressBar view = mapsFragment.getProgressBar(id);
        if(view != null)
            return view;
        else
            return collectionsFragment.getProgressBar(id);

    }

    private TextView getTextView(int id) {
        TextView view = mapsFragment.getTextView(id);
        if(view != null)
            return view;
        else
            return collectionsFragment.getTextView(id);
    }
}
