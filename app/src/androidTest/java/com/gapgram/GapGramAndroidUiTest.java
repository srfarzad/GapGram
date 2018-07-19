package com.gapgram;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.android.dx.command.Main;
import com.gapgram.activity.base.MainFragmentActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class GapGramAndroidUiTest {

    @Rule
    public ActivityTestRule<MainFragmentActivity> main=new ActivityTestRule<>(MainFragmentActivity.class);


    @Test
    public void clickinList()throws Exception{
            //ic_camera
        onView(withId(R.id.ic_camera)).perform(click()).check(matches(isDisplayed()));

    }


}
