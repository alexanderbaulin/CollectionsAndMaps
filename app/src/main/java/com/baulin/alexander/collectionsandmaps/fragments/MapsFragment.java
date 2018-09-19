package com.baulin.alexander.collectionsandmaps.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baulin.alexander.collectionsandmaps.R;

public class MapsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.maps, container, false);
    }

    public void calculateTimeOperations() {
        Log.d("myLogs", "aaaaaaaaaaaaaa");

    }
}
