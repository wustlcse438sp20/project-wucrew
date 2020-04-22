package com.example.beerdiary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer

class ExploreListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.explore_item, parent, false)) {
    private val beerNameView: TextView
    private val beerCalorieView: TextView

    init {
        beerNameView = itemView.findViewById(R.id.beer_name)
        beerCalorieView = itemView.findViewById(R.id.beer_calorie)
    }

    fun bind(beer: Beer, clickListener: (Beer) -> Unit) {
        beerNameView.setOnClickListener {
            clickListener(beer)
        }
        if (beer.product_name != ""){
            beerNameView?.text = beer.product_name
            val calories = beer.nutriments.energy_value?.toString()
            if (calories == "0.0"){
                beerCalorieView?.text = "calories unavailable"
            }
            else {
                beerCalorieView?.text = beer.nutriments.energy_value?.toString() + " calories"
            }
        }

    }
}

class ExploreListAdapter(private val list: ArrayList<Beer>, val clickListener: (Beer) -> Unit)
    : RecyclerView.Adapter<ExploreListViewHolder>() {

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