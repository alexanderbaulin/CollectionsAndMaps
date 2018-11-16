package com.baulin.alexander.collectionsandmaps;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ProgressBar;

import com.baulin.alexander.collectionsandmaps.dagger2.App;
import com.baulin.alexander.collectionsandmaps.mvp.interfaces.Model;
import com.baulin.alexander.collectionsandmaps.mvp.model.Constants;
import com.baulin.alexander.collectionsandmaps.mvp.ui.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // AppModule of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.baulin.alexander.collectionsandmaps", appContext.getPackageName());
    }

    @Test
    public void inputStringTest() {
        onView(withId(R.id.editNumber)).perform(typeText(""));
        onView(withId(R.id.editNumber)).perform(typeText("dsf"));
        onView(withId(R.id.editNumber)).perform(typeText("10000"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());

        main.get().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ProgressBar progressBar = main.get().findViewById(R.id.progressBar);
        while (true) {
            if(progressBar.getVisibility() == View.GONE) break;
        }

        onView(withId(R.id.btnFloatingAction)).perform(click());
        onView(withId(R.id.main_content)).perform(ViewActions.swipeLeft());
        onView(withId(R.id.btnFloatingAction)).perform(click());

        main.get().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }





}
