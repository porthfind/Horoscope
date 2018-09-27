package com.rdev.horoscopemvvm;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.content.Intent;


import com.rdev.horoscopemvvm.ui.extended.ExtendedActivity;
import com.rdev.horoscopemvvm.ui.extended.ExtendedViewModel;
import com.rdev.horoscopemvvm.ui.main.MainActivity;
import com.rdev.horoscopemvvm.ui.sign.SignActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.rdev.horoscopemvvm", appContext.getPackageName());
    }


/*
    //testing buttons
    @Test
    public void clickHoroscopesAquarius() throws Exception {

        Espresso.onView(withText("Aquarius")).perform(click());
    }
*/

    @Test
    public void clickHoroscopesPisces() throws Exception {


        Intents.init();

        try {
            Espresso.onView(withText("Pisces")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }

    }

    @Test
    public void clickHoroscopesAries() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Aries")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesTaurus() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Taurus")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesGemini() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Gemini")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesCancer() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Cancer")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesLeo() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Leo")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesVirgo() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Virgo")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesLibra() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Libra")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesScorpius() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Scorpio")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesSagitarius() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Sagittarius")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesCapricorn() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Capricorn")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }

    @Test
    public void clickHoroscopesWhich() throws Exception {
        Intents.init();

        try {
            Espresso.onView(withText("Which one ?")).perform( click());
            intended(hasComponent(SignActivity.class.getName()));
        } finally {
            Intents.release();
        }
    }




}
