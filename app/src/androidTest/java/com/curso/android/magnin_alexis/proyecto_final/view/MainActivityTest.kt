package com.curso.android.magnin_alexis.proyecto_final.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.magnin_alexis.proyecto_final.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_clickCompararTextosVacios(){
        Espresso.onView(
            ViewMatchers.withId(R.id.bt_comparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.label_resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.resultado_error)
            )
        )
    }

    @Test
    fun mainActivity_clickCompararTextosIguales(){
        Espresso.onView(
            ViewMatchers.withId(R.id.edit_texto1)
        ).perform(
            ViewActions.typeText("hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.edit_texto2)
        ).perform(
            ViewActions.typeText("hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.bt_comparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.label_resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.resultado_true)
            )
        )
    }

    @Test
    fun mainActivity_clickCompararTextosDiferentes(){
        Espresso.onView(
            ViewMatchers.withId(R.id.edit_texto1)
        ).perform(
            ViewActions.typeText("hola")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.edit_texto2)
        ).perform(
            ViewActions.typeText("chau")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.bt_comparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.label_resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.resultado_false)
            )
        )
    }
}