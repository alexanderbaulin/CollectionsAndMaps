package com.baulin.alexander.collectionsandmaps.mvp.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.R;
import com.baulin.alexander.collectionsandmaps.mvp.model.Constants;
import com.baulin.alexander.collectionsandmaps.mvp.model.copyOnWriteArrayList.CopyOnWriteTest;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionsFragment extends Fragment {

    @BindView(R.id.txtArrayAddBegin) TextView txtArrayAddBegin;
    @BindView(R.id.txtArrayAddMiddle) TextView txtArrayAddMiddle;
    @BindView(R.id.txtArrayAddEnd) TextView txtArrayAddEnd;
    @BindView(R.id.txtArraySearchValue) TextView txtArraySearchValue;
    @BindView(R.id.txtArrayRemoveBegin) TextView txtArrayRemoveBegin;
    @BindView(R.id.txtArrayRemoveMiddle) TextView txtArrayRemoveMiddle;
    @BindView(R.id.txtArrayRemoveEnd) TextView txtArrayRemoveEnd;

    @BindView(R.id.txtLinkedAddBegin) TextView txtLinkedAddBegin;
    @BindView(R.id.txtLinkedAddMiddle) TextView txtLinkedAddMiddle;
    @BindView(R.id.txtLinkedAddEnd) TextView txtLinkedAddEnd;
    @BindView(R.id.txtLinkedSearchValue) TextView txtLinkedSearchValue;
    @BindView(R.id.txtLinkedRemoveBegin) TextView txtLinkedRemoveBegin;
    @BindView(R.id.txtLinkedRemoveMiddle) TextView txtLinkedRemoveMiddle;
    @BindView(R.id.txtLinkedRemoveEnd) TextView txtLinkedRemoveEnd;

    @BindView(R.id.txtCopyOnWriteAddBegin) TextView txtCopyOnWriteAddBegin;
    @BindView(R.id.txtCopyOnWriteAddMiddle) TextView txtCopyOnWriteAddMiddle;
    @BindView(R.id.txtCopyOnWriteAddEnd) TextView txtCopyOnWriteAddEnd;
    @BindView(R.id.txtCopyOnWriteSearchValue) TextView txtCopyOnWriteSearchValue;
    @BindView(R.id.txtCopyOnWriteRemoveBegin) TextView txtCopyOnWriteRemoveBegin;
    @BindView(R.id.txtCopyOnWriteRemoveMiddle) TextView txtCopyOnWriteRemoveMiddle;
    @BindView(R.id.txtCopyOnWriteRemoveEnd) TextView txtCopyOnWriteRemoveEnd;

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


    private Map<String, TableCell> tableCells;

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collections, container, false);
        unbinder = ButterKnife.bind(this, view);

        tableCells = new HashMap<>();

        tableCells.put(Constants.ARRAY_ADD_BEGIN,               new TableCell(txtArrayAddBegin, pbArrayAddBegin));
        tableCells.put(Constants.ARRAY_ADD_MIDDLE,              new TableCell(txtArrayAddMiddle, pbArrayAddMiddle));
        tableCells.put(Constants.ARRAY_ADD_END,                 new TableCell(txtArrayAddEnd, pbArrayAddEnd));
        tableCells.put(Constants.ARRAY_SEARCH_VALUE,            new TableCell(txtArraySearchValue, pbArraySearchValue));
        tableCells.put(Constants.ARRAY_REMOVE_BEGIN,            new TableCell(txtArrayRemoveBegin, pbArrayRemoveBegin));
        tableCells.put(Constants.ARRAY_REMOVE_MIDDLE,           new TableCell(txtArrayRemoveMiddle, pbArrayRemoveMiddle));
        tableCells.put(Constants.ARRAY_REMOVE_END,              new TableCell(txtArrayRemoveEnd, pbArrayRemoveEnd));

        tableCells.put(Constants.LINKED_ADD_BEGIN,              new TableCell(txtLinkedAddBegin, pbLinkedAddBegin));
        tableCells.put(Constants.LINKED_ADD_MIDDLE,             new TableCell(txtLinkedAddMiddle, pbLinkedAddMiddle));
        tableCells.put(Constants.LINKED_ADD_END,                new TableCell(txtLinkedAddEnd, pbLinkedAddEnd));
        tableCells.put(Constants.LINKED_SEARCH_VALUE,           new TableCell(txtLinkedSearchValue, pbLinkedSearchValue));
        tableCells.put(Constants.LINKED_REMOVE_BEGIN,           new TableCell(txtLinkedRemoveBegin, pbLinkedRemoveBegin));
        tableCells.put(Constants.LINKED_REMOVE_MIDDLE,          new TableCell(txtLinkedRemoveMiddle, pbLinkedRemoveMiddle));
        tableCells.put(Constants.LINKED_REMOVE_END,             new TableCell(txtLinkedRemoveEnd, pbLinkedRemoveEnd));

        tableCells.put(Constants.COPY_ON_WRITE_ADD_BEGIN,       new TableCell(txtCopyOnWriteAddBegin, pbCopyOnWriteAddBegin));
        tableCells.put(Constants.COPY_ON_WRITE_ADD_MIDDLE,      new TableCell(txtCopyOnWriteAddMiddle, pbCopyOnWriteAddMiddle));
        tableCells.put(Constants.COPY_ON_WRITE_ADD_END,         new TableCell(txtCopyOnWriteAddEnd, pbCopyOnWriteAddEnd));
        tableCells.put(Constants.COPY_ON_WRITE_SEARCH_VALUE,    new TableCell(txtCopyOnWriteSearchValue, pbCopyOnWriteSearchValue));
        tableCells.put(Constants.COPY_ON_WRITE_REMOVE_BEGIN,    new TableCell(txtCopyOnWriteRemoveBegin, pbCopyOnWriteRemoveBegin));
        tableCells.put(Constants.COPY_ON_WRITE_REMOVE_MIDDLE,   new TableCell(txtCopyOnWriteRemoveMiddle, pbCopyOnWriteRemoveMiddle));
        tableCells.put(Constants.COPY_ON_WRITE_REMOVE_END,      new TableCell(txtCopyOnWriteRemoveEnd, pbCopyOnWriteRemoveEnd));

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        for(String key: tableCells.keySet()) {
            String result = tableCells.get(key).getTextView().getText().toString();
            outState.putString(key, result);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            for(String key: tableCells.keySet()) {
                TextView view = tableCells.get(key).getTextView();
                String result = savedInstanceState.getString(key);
                view.setText(result);
            }
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setProgressBarsVisible() {
        for(String key: tableCells.keySet()) {
            tableCells.get(key).getProgressBar().setVisibility(View.VISIBLE);
        }
    }

    public void setTestResult(String stringId, long result) {
        TableCell tableCell = tableCells.get(stringId);
        tableCell.getProgressBar().setVisibility(View.INVISIBLE);
        tableCell.getTextView().setText(String.valueOf(result));
    }
}
