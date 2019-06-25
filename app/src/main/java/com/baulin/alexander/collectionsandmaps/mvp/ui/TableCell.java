package com.baulin.alexander.collectionsandmaps.mvp.ui;

import android.widget.ProgressBar;
import android.widget.TextView;

class TableCell {
    private TextView textView;
    private ProgressBar progressBar;

    TableCell(TextView textView, ProgressBar progressBar) {
        this.textView = textView;
        this.progressBar = progressBar;
    }

    TextView getTextView() {
        return textView;
    }

    ProgressBar getProgressBar() {
        return progressBar;
    }
}
