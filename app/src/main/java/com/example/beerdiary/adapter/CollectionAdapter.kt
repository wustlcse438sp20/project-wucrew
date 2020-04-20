package com.example.beerdiary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.beerdiary.BeerViewModel
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer
import com.example.beerdiary.db.AddBeerItem

//define the binding for the view holder
class CollectionViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.collection_beer_item, parent, false)) {
    private val container: ConstraintLayout
    private val nameView: TextView
    private val ratingView: TextView
    private val quantityView: TextView
    private val more: ImageButton
    private val less: ImageButton
    private val trashcan: ImageButton

    init {
        container = itemView.findViewById(R.id.collection_beer_item_container)
        nameView = itemView.findViewById(R.id.beer_name)
        ratingView = itemView.findViewById(R.id.beer_rating)
        quantityView = itemView.findViewById(R.id.beer_quantity)
        more = itemView.findViewById(R.id.button_more)
        less = itemView.findViewById(R.id.button_less)
        trashcan = itemView.findViewById(R.id.trashcan)
    }
    //pass in view model
    fun bind(beer: AddBeerItem, clickListener: (AddBeerItem) -> Unit, vm: BeerViewModel) {
        nameView.setOnClickListener { clickListener(beer) }
        trashcan.setOnClickListener { vm.delete(beer.id)}
        nameView.text = beer.name
        ratingView.text = beer.rating.toString()
        more.setOnClickListener {
            quantityView.text = (quantityView.text.toString().toInt() + 1).toString()
        }
        less.setOnClickListener {
            if(quantityView.text.toString().toInt()>1){
                quantityView.text = (quantityView.text.toString().toInt() - 1).toString()
            }
        }
    }
}

//define the adapter for the recycler view
class CollectionAdapter(private val list: ArrayList<AddBeerItem>, val clickListener: (AddBeerItem) -> Unit, val vm: BeerViewModel) : RecyclerView.Adapter<CollectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CollectionViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val user: AddBeerItem = list[position]
        holder.bind(user, clickListener, vm)
    }

    override fun getItemCount(): Int = list.size
}
