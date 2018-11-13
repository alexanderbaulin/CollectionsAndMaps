package com.baulin.alexander.collectionsandmaps.mvp.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.R;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionsFragment extends Fragment {

    @BindView(R.id.txtArrayAddBegin) TextView arrayAddBegin;
    @BindView(R.id.txtArrayAddMiddle) TextView arrayAddMiddle;
    @BindView(R.id.txtArrayAddEnd) TextView arrayAddEnd;
    @BindView(R.id.txtArraySearchValue) TextView arraySearchValue;
    @BindView(R.id.txtArrayRemoveBegin) TextView arrayRemoveBegin;
    @BindView(R.id.txtArrayRemoveMiddle) TextView arrayRemoveMiddle;
    @BindView(R.id.txtArrayRemoveEnd) TextView arrayRemoveEnd;

    @BindView(R.id.txtLinkedAddBegin) TextView linkedAddBegin;
    @BindView(R.id.txtLinkedAddMiddle) TextView linkedAddMiddle;
    @BindView(R.id.txtLinkedAddEnd) TextView linkedAddEnd;
    @BindView(R.id.txtLinkedSearchValue) TextView linkedSearchValue;
    @BindView(R.id.txtLinkedRemoveBegin) TextView linkedRemoveBegin;
    @BindView(R.id.txtLinkedRemoveMiddle) TextView linkedRemoveMiddle;
    @BindView(R.id.txtLinkedRemoveEnd) TextView linkedRemoveEnd;

    @BindView(R.id.txtCopyOnWriteAddBegin) TextView copyOnWriteAddBegin;
    @BindView(R.id.txtCopyOnWriteAddMiddle) TextView copyOnWriteAddMiddle;
    @BindView(R.id.txtCopyOnWriteAddEnd) TextView copyOnWriteAddEnd;
    @BindView(R.id.txtCopyOnWriteSearchValue) TextView copyOnWriteSearchValue;
    @BindView(R.id.txtCopyOnWriteRemoveBegin) TextView copyOnWriteRemoveBegin;
    @BindView(R.id.txtCopyOnWriteRemoveMiddle) TextView copyOnWriteRemoveMiddle;
    @BindView(R.id.txtCopyOnWriteRemoveEnd) TextView copyOnWriteRemoveEnd;

    @BindView(R.id.pbArrayAddBegin) ProgressBar pbArrayAddBegin;
    @BindView(R.id.pbArrayAddMiddle) ProgressBar pbArrayAddMiddle;
    @BindView(R.id.pbArrayAddEnd) ProgressBar pbArrayAddEnd;
    @BindView(R.id.pbArraySearchValue) ProgressBar pbArraySearchValue;
    @BindView(R.id.pbArrayRemoveBegin) ProgressBar pbArrayRemoveBegin;
    @BindView(R.id.pbArrayRemoveMiddle) ProgressBar pbArrayRemoveMiddle;
    @BindView(R.id.pbArrayRemoveEnd) ProgressBar pbArrayRemoveEnd;

    @BindView(R.id.pbLinkedAddBegin) ProgressBar pbLinkedAddBegin;
    @BindView(R.id.pbLinkedAddMiddle) ProgressBar pbLinkedAddMiddle;
    @BindView(R.id.pbLinkedAddEnd) ProgressBar pbLinkedAddEnd;
    @BindView(R.id.pbLinkedSearchValue) ProgressBar pbLinkedSearchValue;
    @BindView(R.id.pbLinkedRemoveBegin) ProgressBar pbLinkedRemoveBegin;
    @BindView(R.id.pbLinkedRemoveMiddle) ProgressBar pbLinkedRemoveMiddle;
    @BindView(R.id.pbLinkedRemoveEnd) ProgressBar pbLinkedRemoveEnd;

    @BindView(R.id.pbCopyOnWriteAddBegin) ProgressBar pbCopyOnWriteAddBegin;
    @BindView(R.id.pbCopyOnWriteAddMiddle) ProgressBar pbCopyOnWriteAddMiddle;
    @BindView(R.id.pbCopyOnWriteAddEnd) ProgressBar pbCopyOnWriteAddEnd;
    @BindView(R.id.pbCopyOnWriteSearchValue) ProgressBar pbCopyOnWriteSearchValue;
    @BindView(R.id.pbCopyOnWriteRemoveBegin) ProgressBar pbCopyOnWriteRemoveBegin;
    @BindView(R.id.pbCopyOnWriteRemoveMiddle) ProgressBar pbCopyOnWriteRemoveMiddle;
    @BindView(R.id.pbCopyOnWriteRemoveEnd) ProgressBar pbCopyOnWriteRemoveEnd;

    private Map<Integer, TextView> textViews;
    private Map<Integer, ProgressBar> progressBars;

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collections, container, false);
       // Log.d("myLogs6", "onCreateView");
        unbinder = ButterKnife.bind(this, view);

        textViews = new TreeMap<>();

        putTextView(arrayAddBegin);
        putTextView(arrayAddMiddle);
        putTextView(arrayAddEnd);
        putTextView(arraySearchValue);
        putTextView(arrayRemoveBegin);
        putTextView(arrayRemoveMiddle);
        putTextView(arrayRemoveEnd);

        putTextView(linkedAddBegin);
        putTextView(linkedAddMiddle);
        putTextView(linkedAddEnd);
        putTextView(linkedSearchValue);
        putTextView(linkedRemoveBegin);
        putTextView(linkedRemoveMiddle);
        putTextView(linkedRemoveEnd);

        putTextView(copyOnWriteAddBegin);
        putTextView(copyOnWriteAddMiddle);
        putTextView(copyOnWriteAddEnd);
        putTextView(copyOnWriteSearchValue);
        putTextView(copyOnWriteRemoveBegin);
        putTextView(copyOnWriteRemoveMiddle);
        putTextView(copyOnWriteRemoveEnd);

        progressBars = new TreeMap<>();

        putProgressBar(pbArrayAddBegin);
        putProgressBar(pbArrayAddMiddle);
        putProgressBar(pbArrayAddEnd);
        putProgressBar(pbArraySearchValue);
        putProgressBar(pbArrayRemoveBegin);
        putProgressBar(pbArrayRemoveMiddle);
        putProgressBar(pbArrayRemoveEnd);

        putProgressBar(pbLinkedAddBegin);
        putProgressBar(pbLinkedAddMiddle);
        putProgressBar(pbLinkedAddEnd);
        putProgressBar(pbLinkedSearchValue);
        putProgressBar(pbLinkedRemoveBegin);
        putProgressBar(pbLinkedRemoveMiddle);
        putProgressBar(pbLinkedRemoveEnd);

        putProgressBar(pbCopyOnWriteAddBegin);
        putProgressBar(pbCopyOnWriteAddMiddle);
        putProgressBar(pbCopyOnWriteAddEnd);
        putProgressBar(pbCopyOnWriteSearchValue);
        putProgressBar(pbCopyOnWriteRemoveBegin);
        putProgressBar(pbCopyOnWriteRemoveMiddle);
        putProgressBar(pbCopyOnWriteRemoveEnd);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        for(Integer key: textViews.keySet()) {
            saveTextFieldState(outState, textViews.get(key));
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            for(Integer key: textViews.keySet()) {
                restoreTextFieldState(savedInstanceState, textViews.get(key));
            }
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // Log.d("myLogs6", "onDestroyView");
        unbinder.unbind();
    }

    public ProgressBar getProgressBar(int id) {
        return progressBars.get(id);
    }

    public TextView getTextView(int id) {
        return textViews.get(id);
    }

    private void saveTextFieldState(Bundle outState, TextView view) {
        outState.putString(String.valueOf(view.getId()), view.getText().toString());
    }

    private void restoreTextFieldState(Bundle savedInstanceState, TextView view) {
        view.setText(savedInstanceState.getString(String.valueOf(view.getId())));
    }

    private void putProgressBar(ProgressBar view) {
        progressBars.put(view.getId(), view);
    }

    private void putTextView(TextView view) {
        textViews.put(view.getId(), view);
    }

    public void setProgressBarsVisible() {
        for(Integer key: progressBars.keySet()) {
             progressBars.get(key).setVisibility(View.VISIBLE);
        }
    }
}
