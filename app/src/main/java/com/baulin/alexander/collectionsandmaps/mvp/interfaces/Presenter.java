package com.baulin.alexander.collectionsandmaps.mvp.interfaces;


public interface Presenter {
    void setView(View v);
    void onSubmitButtonClicked();
    void onFloatingCalculationButtonClicked();
}
