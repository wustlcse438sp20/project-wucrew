package com.example.beerdiary.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

class AddBeerRepository(private val addBeerDao: AddBeerItemDao) {
    val allBeers: LiveData<List<AddBeerItem>> = addBeerDao.getBeers()
    val beerData: LiveData<List<AddBeerItem>> = MutableLiveData()

    fun insert(beer: AddBeerItem) {
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.insert(beer)
        }
    }
    fun search(id: Int): LiveData<List<AddBeerItem>> {
        println(addBeerDao.search(id).value.toString())

        return addBeerDao.search(id)
    }
    fun delete(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.delete(id)
        }
    }
    fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.deleteAll()
        }
    }
    fun sortNameAsc(): LiveData<List<AddBeerItem>> {
        return addBeerDao.sortNameAsc()
    }
    fun sortRatingAsc(): LiveData<List<AddBeerItem>> {
        return addBeerDao.sortRatingAsc()
    }
    fun sortRatingDesc(): LiveData<List<AddBeerItem>> {
        return addBeerDao.sortRatingDesc()
    }
    fun updateItem(beer: AddBeerItem){
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.updateItem(beer)
        }
    }
}