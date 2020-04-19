package com.example.beerdiary.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert

@Dao
interface AddBeerItemDao {

    @Query("SELECT * FROM beers")
    fun getBeers(): LiveData<List<AddBeerItem>>

    @Insert
    fun insert(beer: AddBeerItem)
}