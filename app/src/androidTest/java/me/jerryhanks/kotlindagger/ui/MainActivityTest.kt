package me.jerryhanks.kotlindagger.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import me.jerryhanks.kotlindagger.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author <@Po10cio> on 11/4/17 for AndroidKotlinBoilerplate
 *
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testTextInput() {
        val stringToBeTyped = "This is a simple test text"
        onView(withId(R.id.tvInput))
                .perform(typeText(stringToBeTyped), closeSoftKeyboard())

        //verify that the text is showing
        onView(withId(R.id.tvInput))
                .check(matches(withText(stringToBeTyped)))

        //click the click me  button
        onView(withId(R.id.btnClickMe)).perform(click())


    }

    @Test
    fun testButtonClick() {
        onView(withId(R.id.btnClickMe)).perform(click())

    }

    @Test
    fun titleDisplayed() {
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))

        //check that the text is displayed
        onView((withId(R.id.tv_title))).
                check(matches(withText(R.string.android_kotlin_boilerplate_code)))
    }
}