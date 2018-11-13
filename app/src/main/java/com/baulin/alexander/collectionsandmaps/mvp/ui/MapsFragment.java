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

public class MapsFragment extends Fragment {

    @BindView(R.id.txtHashMapAdd) TextView hashMapAdd;
    @BindView(R.id.txtHashMapSearch) TextView hashMapSearch;
    @BindView(R.id.txtHashMapRemove) TextView hashMapRemove;

    @BindView(R.id.txtTreeMapAdd) TextView treeMapAdd;
    @BindView(R.id.txtTreeMapSearch) TextView treeMapSearch;
    @BindView(R.id.txtTreeMapRemove) TextView treeMapRemove;

    @BindView(R.id.pbHashMapAdd) ProgressBar pbHashMapAdd;
    @BindView(R.id.pbHashMapSearch) ProgressBar pbHashMapSearch;
    @BindView(R.id.pbHashMapRemove) ProgressBar pbHashMapRemove;

    @BindView(R.id.pbTreeMapAdd) ProgressBar pbTreeMapAdd;
    @BindView(R.id.pbTreeMapSearch) ProgressBar pbTreeMapSearch;
    @BindView(R.id.pbTreeMapRemove) ProgressBar pbTreeMapRemove;

    private Map<Integer, TextView> textViews;
    private Map<Integer, ProgressBar> progressBars;

    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maps, container, false);
        unbinder = ButterKnife.bind(this, view);

        textViews = new TreeMap<>();

        putTextView(hashMapAdd);
        putTextView(hashMapSearch);
        putTextView(hashMapRemove);

        putTextView(treeMapAdd);
        putTextView(treeMapSearch);
        putTextView(treeMapRemove);

        progressBars = new TreeMap<>();

        putProgressBar(pbHashMapAdd);
        putProgressBar(pbHashMapSearch);
        putProgressBar(pbHashMapRemove);

        putProgressBar(pbTreeMapAdd);
        putProgressBar(pbTreeMapSearch);
        putProgressBar(pbTreeMapRemove);

       // Log.d("rotate_crush", "Фрагмент в onCreateView " + this.toString());

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
        unbinder.unbind();
    }

    public ProgressBar getProgressBar(int id) {
        return progressBars.get(id);
    }


    public TextView getTextView(int id) {
        return textViews.get(id);
    }

    private void putProgressBar(ProgressBar view) {
        progressBars.put(view.getId(), view);
    }

    private void putTextView(TextView view) {
        textViews.put(view.getId(), view);
    }

    private void saveTextFieldState(Bundle outState, TextView view) {
        outState.putString(String.valueOf(view.getId()), view.getText().toString());
    }

    private void restoreTextFieldState(Bundle savedInstanceState, TextView view) {
        view.setText(savedInstanceState.getString(String.valueOf(view.getId())));
    }

    public void setProgressBarsVisible() {
        for(Integer key: progressBars.keySet()) {
            progressBars.get(key).setVisibility(View.VISIBLE);
        }
    }
}
