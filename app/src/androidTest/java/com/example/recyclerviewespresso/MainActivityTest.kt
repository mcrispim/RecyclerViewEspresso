package com.example.recyclerviewespresso

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    private val CARLOS_REVERSED = "2 - Carlos".reversed()

    @Test(expected = PerformException::class)
    fun itemWithText_CARLOS_REVERSED_doesNotExist() {
        // Attempt to scroll to an item that contains the special text.
        Espresso.onView(ViewMatchers.withId(R.id.rvNomes)) // scrollTo will fail the test if no item matches.
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText(CARLOS_REVERSED))
                )
            )
    }

    @Test
    fun scrollTo3rdItem_checkItsText() {
        // First scroll to the position that needs to be matched and click on it.
        Espresso.onView(ViewMatchers.withId(R.id.rvNomes))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2, ViewActions.click()
                )
            )

        // Match the text in an item below the fold and check that it's displayed.
        Espresso.onView(ViewMatchers.withText(CARLOS_REVERSED))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


}