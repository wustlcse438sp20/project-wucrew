package com.example.beerdiary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.beerdiary.data.Beer
import com.example.beerdiary.network.BeerRepository

class BeerViewModel(application: Application) : AndroidViewModel(application) {

    public var beerList: MutableLiveData<List<Beer>> = MutableLiveData()
    public var beerRepository: BeerRepository = BeerRepository()

    fun getBeer() {
        beerRepository.getBeer(beerList)
    }
}