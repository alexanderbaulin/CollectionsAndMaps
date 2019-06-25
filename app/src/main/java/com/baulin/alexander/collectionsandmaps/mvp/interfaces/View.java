package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


public interface View {
    void showToast(String message);
    boolean isTabCollectionSelected();
    String getInputNumber();

    void setPreSubmitClickedUI();
    void setPostSubmitClickedUI();
    void setPostLoadingUI();
    void setCollectionTestsExecutingUI();
    void setMapsTestsExecutingUI();
    void setTestsPostExecutingUI();

    void setMapsTestResult(String stringId, long result);
    void setCollectionsTestResult(String stringId, long result);
}
