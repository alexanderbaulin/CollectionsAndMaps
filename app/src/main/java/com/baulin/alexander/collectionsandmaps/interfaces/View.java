package com.baulin.alexander.collectionsandmaps.interfaces;



import android.widget.ProgressBar;
import android.widget.TextView;


public interface View {
    void showToast(String message);
    boolean isTabCollectionSelected();
    String getInputNumber();
    ProgressBar getProgressBar(int id);
    TextView getTextView(int id);
    void setPostSubmitClickedUI();
    void setPreSubmitClickedUI();
    void setPostLoadingUI();
}
