package com.example.beerdiary.db

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddBeerRepository(private val addBeerDao: AddBeerItemDao) {
    fun insert(beer: AddBeerItem) {
        CoroutineScope(Dispatchers.IO).launch {
            addBeerDao.insert(beer)
        }
    }
}