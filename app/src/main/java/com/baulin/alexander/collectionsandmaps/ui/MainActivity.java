package com.baulin.alexander.collectionsandmaps.ui;


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

import com.baulin.alexander.collectionsandmaps.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity implements com.baulin.alexander.collectionsandmaps.interfaces.View {
    CollectionsFragment collectionsFragment;
    MapsFragment mapsFragment;
    SectionsPageAdapter pageAdapter;

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.container) ViewPager viewPager;
    @BindView(R.id.btnFloatingAction) FloatingActionButton floatingActionButton;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.btnSubmit) Button submit;
    @BindView(R.id.editNumber) EditText input;

    Presenter presenter = new Presenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("myLogs", "onCreate");

        ButterKnife.bind(this);

        mapsFragment = new MapsFragment();
        collectionsFragment = new CollectionsFragment();
        pageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(collectionsFragment, "Collections");
        pageAdapter.addFragment(mapsFragment, "Maps");
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setPreSubmitClickedUI();
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
        Log.d("myLogs", "restore");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isTabCollectionSelected() {
        TabLayout.Tab tabCollection = tabLayout.getTabAt(0);
        return tabCollection != null && tabCollection.isSelected();
    }

    @Override
    public String getInputNumber() {
        return input.getText().toString().trim();
    }

    @Override
    public ProgressBar getProgressBar(int id) {
        ProgressBar view = mapsFragment.getView().findViewById(id);
        if(view != null)
            return view;
        else
            return collectionsFragment.getView().findViewById(id);
    }

    @Override
    public TextView getTextView(int id) {
        TextView view = mapsFragment.getView().findViewById(id);
        if(view != null)
            return view;
        else
            return collectionsFragment.getView().findViewById(id);
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
    }

}
