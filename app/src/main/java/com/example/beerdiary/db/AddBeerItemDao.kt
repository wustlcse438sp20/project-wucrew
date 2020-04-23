package com.example.beerdiary.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

@Dao
interface AddBeerItemDao {

    @Query("SELECT * FROM beers")
    fun getBeers(): LiveData<List<AddBeerItem>>

    @Query("SELECT * FROM beers WHERE beers.id = :id")
    fun search(id: Int): LiveData<List<AddBeerItem>>

    @Insert
    fun insert(beer: AddBeerItem)

    @Query("DELETE FROM beers WHERE beers.id = :id")
    fun delete(id: Int)

    @Query("DELETE FROM beers")
    fun deleteAll()

    @Query("SELECT * FROM beers ORDER BY name ASC")
    fun sortNameAsc(): LiveData<List<AddBeerItem>>

    @Query("SELECT * FROM beers ORDER BY rating DESC")
    fun sortRatingAsc(): LiveData<List<AddBeerItem>>

    @Query("SELECT * FROM beers ORDER BY rating ASC")
    fun sortRatingDesc(): LiveData<List<AddBeerItem>>

    @Update(onConflict = REPLACE)
    fun updateItem(beer: AddBeerItem)
}