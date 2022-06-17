package com.example.foodish.modules.home.breed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.foodish.R
import com.example.foodish.network.response.Breed
import com.example.foodish.network.response.FruitDrink
import kotlinx.android.synthetic.main.layout_breed_list__item.view.*

class FruitDrinkListAdapter(
    private var fruitDrinkList: ArrayList<FruitDrink>
) : RecyclerView.Adapter<FruitDrinkListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(fruitDrink: FruitDrink) {
            itemView.tv_breed_name?.text = fruitDrink.name
            itemView.tv_breed_description?.text = fruitDrink.family
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem: View =
            layoutInflater.inflate(R.layout.layout_breed_list__item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fruitDrinkList[position])
    }

    override fun getItemCount(): Int {
        return fruitDrinkList.size
    }

    fun updateBreedList(fruitDrinkList: ArrayList<FruitDrink>) {
        this.fruitDrinkList = fruitDrinkList
        notifyDataSetChanged()
    }
}