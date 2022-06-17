package com.example.foodish.modules.home.breed.data.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.foodish.R
import com.example.foodish.common.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()

//        shopFragment()
//        initBottomNavigation()
    }

    private fun initViews() {
        layout_veg.setOnClickListener(this)
        layout_non_veg.setOnClickListener(this)
        layout_dessert.setOnClickListener(this)
        layout_cool_drinks.setOnClickListener(this)
    }

//    private fun initBottomNavigation() {
//        bottom_navigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.shop -> shopFragment()
//                R.id.explore -> exploreFragment()
//                R.id.cart -> cartFragment()
//                R.id.favorite -> favoriteFragment()
//                R.id.account -> accountFragment()
//            }
//            true
//        }
//    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.layout_veg -> {
                launchNextJobsScreen(BreedListActivity::class.java)
            }
            R.id.layout_non_veg -> {
                launchNextJobsScreen(BreedListActivity::class.java)
            }
            R.id.layout_dessert -> {
                launchNextJobsScreen(BreedListActivity::class.java)
            }
            R.id.layout_cool_drinks -> {
                launchNextJobsScreen(BreedListActivity::class.java)
            }
        }
    }

    private fun launchNextJobsScreen(nextScreen: Class<*>) {
        val intent = Intent(this, nextScreen)
        startActivity(intent)
    }
}