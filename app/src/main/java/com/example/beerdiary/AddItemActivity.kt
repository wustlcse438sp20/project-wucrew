package com.example.beerdiary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.beerdiary.db.AddBeerItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_additem.*

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)

        cancel_btn.setOnClickListener {
            cancelClicked()
        }

        add_btn.setOnClickListener {
            addClicked()
        }


        val intent : Intent = getIntent()

        name_input.setText(intent.getStringExtra("name"))
        //calories.text = intent.getStringExtra("calories")
        //Picasso.get().load(intent.getStringExtra("photo_url")).into(photo)
        manufacturer_input.setText(intent.getStringExtra("brand"))
        country_input.setText(intent.getStringExtra("countries"))
    }

    private fun addClicked() {
        val beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        val rating = rBar.getRating()
        if(name_input.text.toString()==""){
            val toast = Toast.makeText(this, "Required fields missing", Toast.LENGTH_LONG)
            toast.show()
        } else{
            val photoURL = if (intent.getStringExtra("photo_url") == null) "null" else intent.getStringExtra("photo_url")
            //params: AddBeerItem(name: String, type: String, desc: String,
            //rating: Float, manufacturer: String, country: String)
            val b = AddBeerItem(name_input.text.toString(), type_input.text.toString(), description_input.text.toString(),
                rating, manufacturer_input.text.toString(), country_input.text.toString(), 1, photoURL)


            beerViewModel.insert(b)

            val toast = Toast.makeText(this, "Beer Added", Toast.LENGTH_SHORT)
            toast.show()
        }
        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun cancelClicked() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}