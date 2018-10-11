package com.baulin.alexander.collectionsandmaps.ui;


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

import java.util.HashMap;
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
        Log.d("myLogs6", "onCreateView");
        unbinder = ButterKnife.bind(this, view);

        textViews = new TreeMap<>();

        textViews.put(arrayAddBegin.getId(), arrayAddBegin);
        textViews.put(arrayAddMiddle.getId(), arrayAddMiddle);
        textViews.put(arrayAddEnd.getId(), arrayAddEnd);
        textViews.put(arraySearchValue.getId(), arraySearchValue);
        textViews.put(arrayRemoveBegin.getId(), arrayRemoveBegin);
        textViews.put(arrayRemoveMiddle.getId(), arrayRemoveMiddle);
        textViews.put(arrayRemoveEnd.getId(),  arrayRemoveEnd);

        textViews.put(linkedAddBegin.getId(), linkedAddBegin);
        textViews.put(linkedAddMiddle.getId(), linkedAddMiddle);
        textViews.put(linkedAddEnd.getId(), linkedAddEnd);
        textViews.put(linkedSearchValue.getId(), linkedSearchValue);
        textViews.put(linkedRemoveBegin.getId(), linkedRemoveBegin);
        textViews.put(linkedRemoveMiddle.getId(), linkedRemoveMiddle);
        textViews.put(linkedRemoveEnd.getId(), linkedRemoveEnd);

        textViews.put(copyOnWriteAddBegin.getId(), copyOnWriteAddBegin);
        textViews.put(copyOnWriteAddMiddle.getId(), copyOnWriteAddMiddle);
        textViews.put(copyOnWriteAddEnd.getId(), copyOnWriteAddEnd);
        textViews.put(copyOnWriteSearchValue.getId(), copyOnWriteSearchValue);
        textViews.put(copyOnWriteRemoveBegin.getId(), copyOnWriteRemoveBegin);
        textViews.put(copyOnWriteRemoveMiddle.getId(), copyOnWriteRemoveMiddle);
        textViews.put(copyOnWriteRemoveEnd.getId(), copyOnWriteRemoveEnd);

        progressBars = new TreeMap<>();

        progressBars.put(pbArrayAddBegin.getId(),  pbArrayAddBegin);
        progressBars.put(pbArrayAddMiddle.getId(), pbArrayAddMiddle);
        progressBars.put(pbArrayAddEnd.getId(), pbArrayAddEnd);
        progressBars.put(pbArraySearchValue.getId(), pbArraySearchValue);
        progressBars.put(pbArrayRemoveBegin.getId(),  pbArrayRemoveBegin);
        progressBars.put(pbArrayRemoveMiddle.getId(), pbArrayRemoveMiddle);
        progressBars.put(pbArrayRemoveEnd.getId(), pbArrayRemoveEnd);

        progressBars.put(pbLinkedAddBegin.getId(), pbLinkedAddBegin);
        progressBars.put(pbLinkedAddMiddle.getId(), pbLinkedAddMiddle);
        progressBars.put(pbLinkedAddEnd.getId(), pbLinkedAddEnd);
        progressBars.put(pbLinkedSearchValue.getId(), pbLinkedSearchValue);
        progressBars.put(pbLinkedRemoveBegin.getId(), pbLinkedRemoveBegin);
        progressBars.put(pbLinkedRemoveMiddle.getId(), pbLinkedRemoveMiddle);
        progressBars.put(pbLinkedRemoveEnd.getId(), pbLinkedRemoveEnd);

        progressBars.put(pbCopyOnWriteAddBegin.getId(), pbCopyOnWriteAddBegin);
        progressBars.put(pbCopyOnWriteAddMiddle.getId(), pbCopyOnWriteAddMiddle);
        progressBars.put(pbCopyOnWriteAddEnd.getId(), pbCopyOnWriteAddEnd);
        progressBars.put(pbCopyOnWriteSearchValue.getId(), pbCopyOnWriteSearchValue);
        progressBars.put(pbCopyOnWriteRemoveBegin.getId(), pbCopyOnWriteRemoveBegin);
        progressBars.put(pbCopyOnWriteRemoveMiddle.getId(), pbCopyOnWriteRemoveMiddle);
        progressBars.put(pbCopyOnWriteRemoveEnd.getId(), pbCopyOnWriteRemoveEnd);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("myLogs6", "onDestroyView");
        unbinder.unbind();
    }

    public ProgressBar getProgressBar(int id) {
        return progressBars.get(id);
    }

    public TextView getTextView(int id) {
        return textViews.get(id);
    }
}
