package com.example.beerdiary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer

class CollectionFragment: Fragment(){
    private var beerList: ArrayList<Beer> = ArrayList()
    //private lateinit var collectionViewModel: CollectionViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

}