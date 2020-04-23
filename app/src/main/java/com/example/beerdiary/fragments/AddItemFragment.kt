package com.example.beerdiary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.beerdiary.BeerViewModel
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer
import com.example.beerdiary.db.AddBeerItem
import kotlinx.android.synthetic.main.activity_additem.*
import kotlinx.android.synthetic.main.collection_beer_item.*

class AddItemFragment: Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_additem, container, false)
        // rbar.stePsize = 3
        val rBar = R.id.rBar

    }

    override fun onStart() {
        super.onStart()

        val beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        add_btn.setOnClickListener {
            val rating = rBar.getRating()
            if(name_input.text.toString()==""){
                val toast = Toast.makeText(this.context, "Required fields missing", Toast.LENGTH_LONG)
                toast.show()
            } else{
                //params: AddBeerItem(name: String, type: String, desc: String,
                //rating: Float, manufacturer: String, country: String)
                val b = AddBeerItem(name_input.text.toString(), type_input.text.toString(), description_input.text.toString(),
                    rating, manufacturer_input.text.toString(), country_input.text.toString(), 1, "null")


                beerViewModel.insert(b)

                val toast = Toast.makeText(this.context, "Beer Added", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

}