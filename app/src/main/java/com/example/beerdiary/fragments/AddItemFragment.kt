package com.example.beerdiary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.fragment.app.Fragment
import com.example.beerdiary.R
import com.example.beerdiary.data.Beer

class AddItemFragment: Fragment(){

    //val rBar = findViewById<RatingBar>(R.id.rBar)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_additem, container, false)
    }

    override fun onStart() {
        super.onStart()
    }

}