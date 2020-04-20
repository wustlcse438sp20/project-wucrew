package com.example.beerdiary.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerdiary.BeerViewModel
import com.example.beerdiary.GetDescription
import com.example.beerdiary.R
import com.example.beerdiary.adapter.ExploreListAdapter
import com.example.beerdiary.data.Beer
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment: Fragment() {

    lateinit var viewModel: BeerViewModel
    lateinit var searchBox: EditText
    var beerList: ArrayList<Beer> = ArrayList<Beer>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /** Temporary for testing **/
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(BeerViewModel::class.java)
        searchBox = view.findViewById<EditText>(R.id.search_box)

        val adapter = ExploreListAdapter(beerList as ArrayList<Beer>, {beerItem : Beer -> beerItemClicked(beerItem)})
        explore_recycler.adapter = adapter
        explore_recycler.layoutManager = LinearLayoutManager(this.context)

        viewModel!!.beerList.observe(this, Observer { Beer ->
            beerList.clear()
            beerList.addAll(Beer)
            adapter.notifyDataSetChanged()
        })

        viewModel.getBeer()
    }

    private fun beerItemClicked(beer: Beer) {
        val descriptionIntent = Intent(this.context, GetDescription::class.java)
        descriptionIntent.putExtra("name", beer.product_name)
        descriptionIntent.putExtra("calories", beer.nutriments.energy_value.toString())
        descriptionIntent.putExtra("photo_url", beer.image_front_url)
        startActivityForResult(descriptionIntent, 1)
    }
}