package com.example.foodish.common

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


/**
 * Base class for all activity present in application
 */

abstract class BaseActivity : AppCompatActivity() {

    protected var toolBar: Toolbar? = null
    protected var titleBar: AppCompatTextView? = null
    protected var isTablet: Boolean = false

    fun updateTitle(title: String) {
        setupToolbar(title)
    }

    fun updateTitleWithoutHome(title: String) {
        //setupToolbarWithOutHome(title)
    }

    companion object {
        val TAG = BaseActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    /**
     * Loads the fragment in to the container.
     *
     * @param container container to which fragment is loaded.
     * @param fragment  fragment which is to be load.
     */
    fun loadFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(container, fragment).commit()
    }

    /**
     * Loads the fragment in to the container
     *
     * @param container container to which fragment is loaded.
     * @param fragment fragment which is to be load.
     * @param tag tag used for the back-stack
     */
    fun loadFragment(container: Int, fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().add(container, fragment)
            .addToBackStack(tag).commit()
    }

    /**
     * Initializes the toolbar as action bar and sets the title.
     *
     *
     * @param title
     */
    fun setupToolbar(title: String?) {
        toolBar?.let {
            titleBar?.text = title
            this.title = null
            setSupportActionBar(it)
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    fun showSnackBar(message: String) {
        val view = window?.decorView?.findViewById(android.R.id.content) as ViewGroup
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    fun toastLong(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    fun toastShort(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    open fun isTablet(context: Context) {
        isTablet = context.resources.configuration.smallestScreenWidthDp >= 600
    }



}
