package com.example.beerdiary.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        searchBox.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() != "" && all.isChecked) {
                    viewModel.getBySearch(p0.toString(), "beers")

                } else if (p0.toString() != "" && wheat.isChecked) {
                    viewModel.getBySearch(p0.toString(), "wheat-beers")

                } else if (p0.toString() != "" && IPA.isChecked) {
                    viewModel.getBySearch(p0.toString(), "india-pale-ale")

                } else if (p0.toString() != "" && lager.isChecked) {
                    viewModel.getBySearch(p0.toString(), "lagers")

                } else if (p0.toString() != "" && stout.isChecked) {
                    viewModel.getBySearch(p0.toString(), "stout")

                }
            }
            override fun onTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        })

        radio_group.setOnCheckedChangeListener { radio_group, id ->
            when (id) {
                all.id -> {
                   viewModel.getBeer()
                }

                wheat.id -> {
                    viewModel.getWheatBeers()
                }

                IPA.id -> {
                    viewModel.getIPA()
                }

                lager.id -> {
                    viewModel.getLagers()
                }

                stout.id -> {
                    viewModel.getStouts()
                }
            }
        }
    }

    private fun beerItemClicked(beer: Beer) {
        val descriptionIntent = Intent(this.context, GetDescription::class.java)
        descriptionIntent.putExtra("name", beer.product_name)
        descriptionIntent.putExtra("calories", beer.nutriments.energy_value.toString())
        descriptionIntent.putExtra("photo_url", beer.image_front_url)
        descriptionIntent.putExtra("brand", beer.brands)
        descriptionIntent.putExtra("countries", beer.countries)
        startActivityForResult(descriptionIntent, 1)
    }
}