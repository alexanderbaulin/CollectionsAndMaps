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

        textViews.put(hashMapAdd.getId(), hashMapAdd);
        textViews.put(hashMapSearch.getId(), hashMapSearch);
        textViews.put(hashMapRemove.getId(), hashMapRemove);

        textViews.put(treeMapAdd.getId(), treeMapAdd);
        textViews.put(treeMapSearch.getId(), treeMapSearch);
        textViews.put(treeMapRemove.getId(), treeMapRemove);

        progressBars = new TreeMap<>();

        progressBars.put(pbHashMapAdd.getId(), pbHashMapAdd);
        progressBars.put(pbHashMapSearch.getId(), pbHashMapSearch);
        progressBars.put(pbHashMapRemove.getId(), pbHashMapRemove);

        progressBars.put(pbTreeMapAdd.getId(), pbTreeMapAdd);
        progressBars.put(pbTreeMapSearch.getId(), pbTreeMapSearch);
        progressBars.put(pbTreeMapRemove.getId(), pbTreeMapRemove);

        Log.d("rotate_crush", "Фрагмент в onCreateView " + this.toString());

        return view;
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
}
