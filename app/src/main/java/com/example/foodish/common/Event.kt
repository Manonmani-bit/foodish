package com.example.foodish.common

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 *
 * With an Event wrapper, you can add multiple observers to a single-use event. i.e., that will
 * only send an update once.
 *
 * Use this EventObserver {@link EventObserver} to remove some repetitive code if you end up having
 * lots of events.
 */
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content

    /**
     * Syntactic sugar to consume event in a block
     */
    fun consume(function: (T) -> Unit) {
        getContentIfNotHandled()?.let {
            function.invoke(it)
        }
    }
}
