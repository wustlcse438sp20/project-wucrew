package com.example.beerdiary.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert

@Dao
interface AddBeerItemDao {

    @Query("SELECT * FROM beers")
    fun getBeers(): LiveData<List<AddBeerItem>>

    @Query("SELECT * FROM beers WHERE beers.id = :id")
    fun search(id: Int): AddBeerItem

    @Insert
    fun insert(beer: AddBeerItem)

    @Query("DELETE FROM beers WHERE beers.id = :id")
    fun delete(id: Int)

    @Query("DELETE FROM beers")
    fun deleteAll()

    @Query("SELECT * FROM beers ORDER BY name ASC")
    fun sortNameAsc(): LiveData<List<AddBeerItem>>

    @Query("SELECT * FROM beers ORDER BY rating ASC")
    fun sortRatingAsc(): LiveData<List<AddBeerItem>>

    @Query("SELECT * FROM beers ORDER BY rating DESC")
    fun sortRatingDesc(): LiveData<List<AddBeerItem>>


}