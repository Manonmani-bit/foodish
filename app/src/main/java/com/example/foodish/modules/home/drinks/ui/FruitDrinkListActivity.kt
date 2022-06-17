package com.example.foodish.modules.home.breed.data.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodish.R
import com.example.foodish.common.BaseActivity
import com.example.foodish.modules.home.breed.adapter.FruitDrinkListAdapter
import com.example.foodish.network.response.Breed
import com.example.foodish.network.response.FruitDrink
import kotlinx.android.synthetic.main.activity_breed_list.*

class FruitDrinkListActivity : BaseActivity() {

    private val fruitDrinkViewModel by lazy { ViewModelProvider(this).get(FruitDrinkViewModel::class.java) }
    private lateinit var adapter: FruitDrinkListAdapter
    private var fruitDrinkList: ArrayList<FruitDrink> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_list)

        initObservers()
        initAdapter()
        initViews()
    }

    private fun initViews() {
        back?.setOnClickListener {
            finish()
        }
    }

    private fun initObservers() {
        fruitDrinkViewModel.fetchBreedListDetails()
        fruitDrinkViewModel.fruitDrinkList.observe(this, Observer {
            progress_bar.visibility = View.GONE
            fruitDrinkList.clear()
            fruitDrinkList.addAll(it)
            adapter.updateBreedList(fruitDrinkList)
        })
    }

    private fun initAdapter() {
        adapter = FruitDrinkListAdapter(fruitDrinkList)
        val layoutManager = LinearLayoutManager(this)
        recycler_view_breeds.layoutManager = layoutManager
        recycler_view_breeds.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}