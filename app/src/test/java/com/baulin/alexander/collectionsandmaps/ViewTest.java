package com.baulin.alexander.collectionsandmaps;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.presenter.Presenter;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;
import com.baulin.alexander.collectionsandmaps.mvp.ui.SectionsPageAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ViewTest {

    @Mock
    private Presenter presenter;
    @Mock
    private SectionsPageAdapter adapter;
    @Mock
    private Button btnSubmit;
    @Mock
    private ProgressBar progressBar;
    @Mock
    private TextView textView;
    @Mock
    private Button btnFloatingAction;
    private MainActivity activity = new MainActivity();


    @Before
    public void init() {
        activity = new MainActivity();
        activity.setPageAdapter(adapter);
        activity.setPresenter(presenter);
        btnSubmit.setId(R.id.btnSubmit);
        btnFloatingAction.setId(R.id.btnFloatingAction);
    }

    @Test
    public void onClickSubmit() {
        activity.onClickSubmitButton(btnSubmit);
        verify(presenter).onSubmitButtonClicked();
    }

    @Test
    public void onClickFloatingButton() {
        activity.onClickFloatingActionButton(btnFloatingAction);
        verify(presenter).onFloatingCalculationButtonClicked();
    }

    @Test
    public void setProgressIndicatorState() {
        int progressBarID = 1;
        int visibility = 2;
        when(adapter.getProgressBar(progressBarID)).thenReturn(progressBar);
        activity.setProgressIndicator(progressBarID, visibility);
        verify(adapter).getProgressBar(progressBarID);
        verify(progressBar).setVisibility(visibility);
    }

    @Test
    public void setTestResult() {
        int progressBarID = 1;
        String result = "12";
        when(adapter.getTextView(progressBarID)).thenReturn(textView);
        activity.setTestResult(progressBarID, result);
        verify(adapter).getTextView(progressBarID);
        verify(textView).setText(result);
    }

    @Test
    public void setCollectionTestsExecutingUI() {
        activity.setCollectionTestsExecutingUI();
        verify(adapter).setCollectionProgressBarsVisible();
    }

    @Test
    public void setMapsTestsExecutingUI() {
        activity.setMapsTestsExecutingUI();
        verify(adapter).setMapsProgressBarsVisible();
    }

}
