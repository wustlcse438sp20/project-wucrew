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
    fun sortNameAsc(): LiveData<List<AddBeerItem>> {
//        CoroutineScope(Dispatchers.IO).launch {
//            addBeerDao.sortNameAsc()
//        }
        return addBeerDao.sortNameAsc()
    }
    fun sortRatingAsc(): LiveData<List<AddBeerItem>> {
//        CoroutineScope(Dispatchers.IO).launch {
//            addBeerDao.sortRatingAsc()
//        }
        return addBeerDao.sortRatingAsc()
    }
    fun sortRatingDesc(): LiveData<List<AddBeerItem>> {
//        CoroutineScope(Dispatchers.IO).launch {
//            addBeerDao.sortRatingDesc()
//        }
        return addBeerDao.sortRatingDesc()
    }
}