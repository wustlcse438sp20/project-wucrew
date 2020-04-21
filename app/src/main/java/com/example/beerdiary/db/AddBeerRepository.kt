package com.example.beerdiary.db

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddBeerRepository(private val addBeerDao: AddBeerItemDao) {
    val allBeers: LiveData<List<AddBeerItem>> = addBeerDao.getBeers()

    fun insert(beer: AddBeerItem) {
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.insert(beer)
        }
    }
    fun search(id: Int): AddBeerItem? {
        lateinit var beer: AddBeerItem
        CoroutineScope(Dispatchers.IO).launch {
            beer = addBeerDao.search(id)
        }
        return beer
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
    fun sortNameAsc() {
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.sortNameAsc()
        }
    }
    fun sortRatingAsc(){
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.sortRatingAsc()
        }
    }
    fun sortRatingDesc(){
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.sortRatingDesc()
        }
    }
}