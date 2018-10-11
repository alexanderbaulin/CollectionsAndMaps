package com.baulin.alexander.collectionsandmaps.interfaces;



import android.widget.ProgressBar;
import android.widget.TextView;


public interface View {
    void showToast(String message);
    boolean isTabCollectionSelected();
    String getInputNumber();
    void setPostSubmitClickedUI();
    void setPreSubmitClickedUI();
    void setPostLoadingUI();
    void setProgressIndicator(int pbID, int visible);
    void setTestResult(int txtID, String result);
}
