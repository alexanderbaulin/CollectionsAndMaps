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

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MapsFragment extends Fragment {

    @BindView(R.id.txtHashMapAdd) TextView txtHashMapAdd;
    @BindView(R.id.txtHashMapSearch) TextView txtHashMapSearch;
    @BindView(R.id.txtHashMapRemove) TextView txtHashMapRemove;

    @BindView(R.id.txtTreeMapAdd) TextView txtTreeMapAdd;
    @BindView(R.id.txtTreeMapSearch) TextView txtTreeMapSearch;
    @BindView(R.id.txtTreeMapRemove) TextView txtTreeMapRemove;

    @BindView(R.id.pbHashMapAdd) ProgressBar pbHashMapAdd;
    @BindView(R.id.pbHashMapSearch) ProgressBar pbHashMapSearch;
    @BindView(R.id.pbHashMapRemove) ProgressBar pbHashMapRemove;

    @BindView(R.id.pbTreeMapAdd) ProgressBar pbTreeMapAdd;
    @BindView(R.id.pbTreeMapSearch) ProgressBar pbTreeMapSearch;
    @BindView(R.id.pbTreeMapRemove) ProgressBar pbTreeMapRemove;

    private Map<String, TableCell> tableCells;

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maps, container, false);
        unbinder = ButterKnife.bind(this, view);

        tableCells = new HashMap<>();

        tableCells.put(Constants.TREE_MAP_ADD,    new TableCell(txtTreeMapAdd, pbTreeMapAdd));
        tableCells.put(Constants.TREE_MAP_SEARCH, new TableCell(txtTreeMapSearch, pbTreeMapSearch));
        tableCells.put(Constants.TREE_MAP_REMOVE, new TableCell(txtTreeMapRemove, pbTreeMapRemove));

        tableCells.put(Constants.HASH_MAP_ADD,    new TableCell(txtHashMapAdd, pbHashMapAdd));
        tableCells.put(Constants.HASH_MAP_SEARCH, new TableCell(txtHashMapSearch, pbHashMapSearch));
        tableCells.put(Constants.HASH_MAP_REMOVE, new TableCell(txtHashMapRemove, pbHashMapRemove));

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
