@file:Suppress("unused")

package com.agoda.kakao.web

import androidx.test.espresso.web.model.Atom
import androidx.test.espresso.web.model.ElementReference
import androidx.test.espresso.web.sugar.Web
import androidx.test.espresso.web.webdriver.DriverAtoms

/**
 * Provides action for interacting with WebViews
 *
 * @see WebView
 */
interface WebActions {
    val web: Web.WebInteraction<*>
    val ref: Atom<ElementReference>

    /**
     * Clicks on element
     */
    fun click() {
        perform(DriverAtoms.webClick())
    }

    /**
     * Input keys with element in focus
     *
     * @param text Text to input
     */
    fun keys(text: String) {
        perform(DriverAtoms.webKeys(text))
    }

    /**
     * Scrolls to the element inside WebView
     */
    fun scroll() {
        perform(DriverAtoms.webScrollIntoView())
    }

    /**
     * Clears the element
     */
    fun clear() {
        perform(DriverAtoms.clearElement())
    }

    /**
     * Performs custom action on element
     *
     * @param action Action to be performed
     */
    private fun perform(action: Atom<*>) {
        web.withElement(ref).perform(action)
    }
}