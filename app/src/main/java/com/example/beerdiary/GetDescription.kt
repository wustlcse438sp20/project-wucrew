package com.example.beerdiary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.beer_detail.*

class GetDescription : AppCompatActivity() {

    private val ADD_BEER_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_detail)


        val intent : Intent = getIntent()

        name.text = intent.getStringExtra("name")
        calories.text = intent.getStringExtra("calories")
        Picasso.get().load(intent.getStringExtra("photo_url")).into(photo)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_BEER_REQUEST) {
            if (resultCode == Activity.RESULT_OK){

            }
        }
    }
}