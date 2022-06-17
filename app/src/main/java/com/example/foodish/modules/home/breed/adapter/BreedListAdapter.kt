package com.example.foodish.modules.home.breed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.foodish.R
import com.example.foodish.network.response.Breed
import kotlinx.android.synthetic.main.layout_breed_list__item.view.*

class BreedListAdapter(
    private var breedList: ArrayList<Breed>
) : RecyclerView.Adapter<BreedListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(breed: Breed) {
            itemView.tv_breed_name?.text = breed.name
            itemView.tv_breed_description?.text = breed.description
            if (breed.image.url!=null) {
                Glide.with(itemView)
                    .load(breed.image.url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fitCenter()
                    .into(itemView.image_breed)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val listItem: View =
            layoutInflater.inflate(R.layout.layout_breed_list__item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(breedList[position])
    }

    override fun getItemCount(): Int {
        return breedList.size
    }

    fun updateBreedList(breedList: ArrayList<Breed>) {
        this.breedList = breedList
        notifyDataSetChanged()
    }
}