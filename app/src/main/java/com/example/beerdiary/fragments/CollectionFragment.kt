package com.example.beerdiary.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerdiary.BeerViewModel
import com.example.beerdiary.GetDescription
import com.example.beerdiary.R
import com.example.beerdiary.adapter.CollectionAdapter
import com.example.beerdiary.data.Beer
import com.example.beerdiary.db.AddBeerItem
import kotlinx.android.synthetic.main.fragment_collection.*
import java.util.*
import kotlin.collections.ArrayList

class CollectionFragment: Fragment(){
    private var addBeerList: ArrayList<AddBeerItem> = ArrayList()
    private lateinit var beerViewModel: BeerViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onStart() {
        super.onStart()

        beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)

        val adapter = CollectionAdapter(addBeerList,
            {beerItem : AddBeerItem -> beerItemClicked(beerItem)},
            beerViewModel)
        collection_recycler.adapter = adapter
        collection_recycler.layoutManager = LinearLayoutManager(this.context)

        beerViewModel.addBeerList.observe(this, Observer { beers ->
            addBeerList.clear()
            addBeerList.addAll(beers)
            adapter.notifyDataSetChanged()
        })

        //FIXME: does not sort the list
        radiogroup.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                name_sort.id -> {beerViewModel.sortNameAsc()
                    //adapter.notifyDataSetChanged()
                    println("name sort")
                }
                high_sort.id -> {beerViewModel.sortRatingAsc()
                    //adapter.notifyDataSetChanged()
                    println("high sort")
                }
                low_sort.id -> {
                    beerViewModel.sortRatingDesc()
                    //adapter.notifyDataSetChanged()
                    println("low sort")
                }
                date_sort.id -> {
                    //beerViewModel.sortRatingDesc()
                    //adapter.notifyDataSetChanged()
                    println("date sort")
                }
            }
        }
    }
    private fun beerItemClicked(beer: AddBeerItem) {
        println("beer item clicked")
        println(beer.id)
    }
}