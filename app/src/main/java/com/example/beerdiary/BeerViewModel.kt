package com.example.beerdiary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.beerdiary.data.Beer
import com.example.beerdiary.db.AddBeerItem
import com.example.beerdiary.db.AddBeerRepository
import com.example.beerdiary.db.AppDatabase
import com.example.beerdiary.network.BeerRepository

class BeerViewModel(application: Application) : AndroidViewModel(application) {
    var beerList: MutableLiveData<List<Beer>> = MutableLiveData()   //for api
    var addBeerList: LiveData<List<AddBeerItem>> = MutableLiveData() //for database

    private val beerRepository: BeerRepository = BeerRepository() //-> this is the api repository

    private val addBeerRepository: AddBeerRepository = AddBeerRepository(
        AppDatabase.getDatabase(application).addBeerDao())  //-> this is the local memory SQLite repository

    init {
        addBeerList = addBeerRepository.allBeers
    }

    fun getBeer() {
        beerRepository.getBeer(beerList)
    }

    fun getBySearch(param: String) {
        beerRepository.getBySearch(beerList, param)
    }
    //function that sends a beer item from AddItemFragment() to CollectionFragment() stored in AppDatabase()
    fun insert(beer: AddBeerItem){
        addBeerRepository.insert(beer)
    }
    fun search(id: Int): AddBeerItem?{
        var beer: AddBeerItem? = addBeerRepository.search(id)
        return beer
    }
    fun delete(id: Int) {
        addBeerRepository.delete(id)
    }
    fun deleteAll(){
        addBeerRepository.deleteAll()
    }
    fun sortNameAsc() : LiveData<List<AddBeerItem>>{
        return addBeerRepository.sortNameAsc()
    }
    fun sortRatingAsc() : LiveData<List<AddBeerItem>>{
        return addBeerRepository.sortRatingAsc()
    }
    fun sortRatingDesc() : LiveData<List<AddBeerItem>>{
        return addBeerRepository.sortRatingDesc()
    }
}