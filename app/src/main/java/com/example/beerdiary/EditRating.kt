package com.example.beerdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.beerdiary.db.AddBeerItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_editrating.*
import java.lang.Exception

class EditRating : AppCompatActivity(){
    lateinit var beerViewModel: BeerViewModel
    var beer: LiveData<List<AddBeerItem>> = MutableLiveData()
    var displayBeer: AddBeerItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editrating)
        beerViewModel = ViewModelProvider(this).get(com.example.beerdiary.BeerViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        val intent = getIntent()
        val id = intent.getIntExtra("id", 0)
        val photo_url = if (intent.getStringExtra("photo_url") == null) "null" else intent.getStringExtra("photo_url")

        if (photo_url == "null") {
            Picasso.get().load(R.drawable.beer_clipart).into(beer_photo)
        } else {
            Picasso.get().load(photo_url).into(beer_photo)
        }

        beerViewModel.search(id)

        beerViewModel.beerData.observe(
            this,
            Observer { beerData: List<AddBeerItem>? -> kotlin.run{
                displayBeer = beerData?.get(0)
                println(beerData?.size.toString())
                edit_name.text = displayBeer?.name
                edit_description.text = displayBeer?.description
                edit_type.text = displayBeer?.type
                edit_rBar.rating = displayBeer!!.rating
                edit_c.text = displayBeer?.country
                edit_m.text = displayBeer?.manufacturer
                edit_type.text = displayBeer?.type

                edit_save.setOnClickListener {
                    var newBeer = AddBeerItem(edit_name.text.toString(), edit_type.text.toString(), edit_description.text.toString(),
                    edit_rBar.rating, edit_m.text.toString(), edit_c.text.toString(), displayBeer!!.quantity, photo_url)
                    if(beer==null){
                        beerViewModel.insert(newBeer)
                    }else {
                        displayBeer?.rating = edit_rBar.rating
                        beerViewModel.updateItem(displayBeer!!)
                    }

                    val toast = Toast.makeText(this, "Changes saved", Toast.LENGTH_SHORT)
                    toast.show()
                    val saveIntent = Intent(this, MainActivity::class.java)
                    startActivity(saveIntent)
                }

                edit_cancel.setOnClickListener {
                    val cancelIntent = Intent(this, MainActivity::class.java)
                    startActivity(cancelIntent)
                }
            }}
        )
        beerViewModel.search(id)
    }
}