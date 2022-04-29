package com.example.bookfinder

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bookfinder.model.BookViewModel
import junit.framework.TestCase
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BookTests {

    // Constants for testing without needing to call an instance
    companion object {
        const val TEST_BOOK_TITLE = "Test title"
        const val ACTION_BAR = "action_bar"
        const val RESULTS_NCDL = "Results from NCDL"
    }

    private val viewModel = BookViewModel()

    @get:Rule
    var activity = ActivityScenarioRule(MainActivity::class.java)

    // Helper function that other tests can reference
    private fun enterTextAndClickSubmit() {
        onView(withId(R.id.book_input_edit_text))
            .perform(typeText(TEST_BOOK_TITLE))
        onView(withId(R.id.submit_button)).perform(click())
    }

    @Test
    fun enterTextAndClickButtonTest() {
        enterTextAndClickSubmit()
    }


    @Test
    fun handOffBookToResultFragment() {
        enterTextAndClickSubmit()

        // Find the view that is 1) a TextView and 2) has a parent with resource name ACTION_BAR
        // then in that view, check that it matches the TEST_BOOK_TITLE
        onView(
            allOf(
                instanceOf(TextView::class.java),
                withParent(withResourceName(ACTION_BAR))
            )
        )
            .check(matches(withText(containsString(TEST_BOOK_TITLE))))
    }

    @Test
    fun resultsOneVisible() {
        enterTextAndClickSubmit()
        TestCase.assertEquals(RESULTS_NCDL, viewModel.resultsNCDL)
    }



}