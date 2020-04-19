package com.example.beerdiary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerdiary.BeerViewModel
import com.example.beerdiary.R
import com.example.beerdiary.adapter.CollectionAdapter
import com.example.beerdiary.data.Beer
import com.example.beerdiary.db.AddBeerItem
import kotlinx.android.synthetic.main.fragment_collection.*

class CollectionFragment: Fragment(){
    private var beerList: ArrayList<AddBeerItem> = ArrayList()
    private lateinit var beerViewModel: BeerViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onStart() {
        super.onStart()

        beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)

        val adapter = CollectionAdapter(beerList)
        collection_recycler.adapter = adapter
        collection_recycler.layoutManager = LinearLayoutManager(this.context)

        beerViewModel.addBeerList.observe(this, Observer { beers ->
            beerList.clear()
            beerList.addAll(beers)
            adapter.notifyDataSetChanged()
        })
    }

}