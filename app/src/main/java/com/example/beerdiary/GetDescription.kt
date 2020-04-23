package com.example.beerdiary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.beerdiary.fragments.AddItemFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.beer_detail.*
import kotlinx.android.synthetic.main.explore_item.*

class GetDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_detail)

        cancel_btn.setOnClickListener {
            cancelClicked()
        }

        add_btn.setOnClickListener {
            addClicked()
        }


        val intent : Intent = getIntent()

        name.text = intent.getStringExtra("name")
        calories.text = intent.getStringExtra("calories")
        if (intent.getStringExtra("photo_url") == null) {
            Picasso.get().load(R.drawable.beer_clipart).into(photo)
            println(intent.getStringExtra("photo_url") + " is the photo url")
        } else {
            Picasso.get().load(intent.getStringExtra("photo_url")).into(photo)
            println(intent.getStringExtra("photo_url") + " is the photo url")

        }
        manufacturer.text = intent.getStringExtra("brand")
        country.text = intent.getStringExtra("countries")


    }

    private fun addClicked() {
        val addBeerItemIntent = Intent(this, AddItemActivity::class.java)
        addBeerItemIntent.putExtra("name", intent.getStringExtra("name"))
        addBeerItemIntent.putExtra("calories", intent.getStringExtra("calories"))
        addBeerItemIntent.putExtra("photo_url", intent.getStringExtra("photo_url"))
        addBeerItemIntent.putExtra("brand", intent.getStringExtra("brand"))
        addBeerItemIntent.putExtra("countries", intent.getStringExtra("countries"))
        startActivityForResult(addBeerItemIntent,Activity.RESULT_OK)
        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun cancelClicked() {
        setResult(Activity.RESULT_OK)
        finish()
    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == ADD_BEER_REQUEST) {
//            if (resultCode == Activity.RESULT_OK){
//
//            }
//        }
//    }
}