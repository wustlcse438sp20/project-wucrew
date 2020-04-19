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
}