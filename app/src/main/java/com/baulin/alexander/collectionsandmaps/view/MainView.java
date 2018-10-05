package com.baulin.alexander.collectionsandmaps.view;



import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.controller.Main;
import com.baulin.alexander.collectionsandmaps.controller.SectionsPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainView {
    private ProgressBar progressBar;
    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    private Button submit;
    private EditText input;
    private AppCompatActivity activity;
    private TabLayout tabLayout;

    //@BindView(R.id.progressBar) ProgressBar progressBar;


    public MainView(AppCompatActivity compatActivity) {
        activity = compatActivity;
        //ButterKnife.bind(activity);
        progressBar = activity.findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(Main.numberOfElements);

        viewPager = activity.findViewById(R.id.container);
        floatingActionButton = activity.findViewById(R.id.btnFloatingAction);
        submit = activity.findViewById(R.id.btnSubmit);
        input = activity.findViewById(R.id.editNumber);
        tabLayout = activity.findViewById(R.id.tabs);
    }

    public void setPageAdapter(SectionsPageAdapter adapter) {
        viewPager.setAdapter(adapter);
        viewPager.setVisibility(View.INVISIBLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setPostExecuteUI() {
        progressBar.setVisibility(View.GONE);
        viewPager.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);
    }

    public boolean submitButtonClicked() {
        String number = input.getText().toString().trim();
        if(number.equals("")) {
            Toast.makeText(activity, "Enter number", Toast.LENGTH_SHORT).show();
            return false;
        }
        Main.numberOfElements = Integer.valueOf(number);
        input.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        Log.d("myLogs5", "button " + Main.numberOfElements);
        return true;
    }


    public boolean isTabCollectionSelected() {
        TabLayout.Tab tabCollection = tabLayout.getTabAt(0);
        return tabCollection != null && tabCollection.isSelected();
    }
}
