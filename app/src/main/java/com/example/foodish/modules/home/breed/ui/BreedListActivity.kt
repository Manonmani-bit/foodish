package com.example.foodish.modules.home.breed.data.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodish.R
import com.example.foodish.common.BaseActivity
import com.example.foodish.modules.home.breed.adapter.BreedListAdapter
import com.example.foodish.modules.home.breed.adapter.FruitDrinkListAdapter
import com.example.foodish.network.response.Breed
import kotlinx.android.synthetic.main.activity_breed_list.*

class BreedListActivity : BaseActivity() {

    private val breedViewModel by lazy { ViewModelProvider(this).get(BreedViewModel::class.java) }
    private lateinit var adapter: BreedListAdapter
    private var breedList: ArrayList<Breed> = arrayListOf()

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
        breedViewModel.fetchBreedListDetails()
        breedViewModel.breedList.observe(this, Observer {
            progress_bar.visibility = View.GONE
            breedList.clear()
            breedList.addAll(it)
            adapter.updateBreedList(breedList)
        })
    }

    private fun initAdapter() {
        adapter = BreedListAdapter(breedList)
        val layoutManager = LinearLayoutManager(this)
        recycler_view_breeds.layoutManager = layoutManager
        recycler_view_breeds.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}