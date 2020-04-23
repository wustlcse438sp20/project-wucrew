package com.example.beerdiary.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer
import com.squareup.picasso.Picasso

class ExploreListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.explore_item, parent, false)) {
    private val beerNameView: TextView
    private val beerCalorieView: TextView
    private val beerImageView: ImageView


    init {
        beerNameView = itemView.findViewById(R.id.beer_name)
        beerCalorieView = itemView.findViewById(R.id.beer_calorie)
        beerImageView = itemView.findViewById(R.id.beer_image)
    }

    fun bind(beer: Beer, clickListener: (Beer) -> Unit) {
        beerImageView.setOnClickListener {
            clickListener(beer)
        }
        beerNameView?.text = beer.product_name
        val calories = beer.nutriments.energy_value?.toString()
        if (calories == "0.0") {
            beerCalorieView?.text = "calories unavailable"
        } else {
            beerCalorieView?.text = beer.nutriments.energy_value?.toString() + " calories"
        }
        if (beer.image_front_url == null) {
            Picasso.get().load(R.drawable.beer_clipart).into(beerImageView)
        } else {
            Picasso.get().load(beer.image_front_url).into(beerImageView)
        }

    }
}

class ExploreListAdapter(private val list: ArrayList<Beer>, val clickListener: (Beer) -> Unit) :
    RecyclerView.Adapter<ExploreListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ExploreListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ExploreListViewHolder, position: Int) {
        val beer: Beer = list[position]
        holder.bind(beer, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}