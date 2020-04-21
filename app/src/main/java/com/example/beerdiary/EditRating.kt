package com.example.beerdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.beerdiary.db.AddBeerItem
import kotlinx.android.synthetic.main.activity_editrating.*
import java.lang.Exception

class EditRating : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editrating)
    }

    override fun onStart() {
        super.onStart()
        val intent = getIntent()
        val id = intent.getIntExtra("id", 0)

        val beerViewModel: BeerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        var beer: AddBeerItem? = null
        try {
            beer = beerViewModel.search(id)
        } catch (e: Exception){
            val toast = Toast.makeText(this, "Error: search failed", Toast.LENGTH_SHORT)
            toast.show()
        }

        if(beer?.name!=null){
            edit_name.text = beer.name
            edit_rBar.rating = beer.rating
            edit_c.text = beer.country
            edit_m.text = beer.manufacturer
            edit_type.text = beer.type
        } else{
            val toast = Toast.makeText(this, "Error: failed to load data", Toast.LENGTH_SHORT)
            toast.show()
        }
        edit_save.setOnClickListener {
            var newBeer = AddBeerItem(edit_name.text.toString(), edit_type.text.toString(), edit_description.text.toString(),
                edit_rBar.rating, edit_m.text.toString(), edit_c.text.toString())
            if(beer==null){
                beerViewModel.insert(newBeer)
            }else{
                beerViewModel.delete(beer.id)
                beerViewModel.insert(newBeer)
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
    }
}