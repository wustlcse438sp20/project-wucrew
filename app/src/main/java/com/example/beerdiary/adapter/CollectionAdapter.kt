package com.example.beerdiary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer

//define the binding for the view holder
class CollectionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.collection_beer_item, parent, false)) {
    private val nameView: TextView
    private val ratingView: TextView


    init {
        nameView = itemView.findViewById(R.id.beer_name)
        ratingView = itemView.findViewById(R.id.beer_rating)
    }

    fun bind(beer: Beer) {
        nameView.text = beer.product_name
    }
}


//define the adapter for the recycler view
class CollectionAdapter(private val list: ArrayList<Beer>) : RecyclerView.Adapter<CollectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CollectionViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val user: Beer = list[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = list.size

}