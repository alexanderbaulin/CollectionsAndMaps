package com.baulin.alexander.collectionsandmaps.mvp.model;


public class TestTask {

    private int txtID;
    private int pbID;
    private String name;


    TestTask(int targetTextViewId, int targetProgressBarId, String operationName) {
        name = operationName;
        pbID = targetProgressBarId;
        txtID = targetTextViewId;
    }

    public String getName() {
        return name;
    }

    public int getPbID() {
        return pbID;
    }

    public int getTxtID() {
        return txtID;
    }
}
