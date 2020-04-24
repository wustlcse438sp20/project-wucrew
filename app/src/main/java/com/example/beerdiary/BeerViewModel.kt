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
    var beerData: LiveData<List<AddBeerItem>> = MutableLiveData()

    private val beerRepository: BeerRepository = BeerRepository() //-> this is the api repository

    private val addBeerRepository: AddBeerRepository = AddBeerRepository(
        AppDatabase.getDatabase(application).addBeerDao())  //-> this is the local memory SQLite repository

    init {
        addBeerList = addBeerRepository.allBeers
    }

    fun getBeer() {
        beerRepository.getBeer(beerList)
    }

    fun getBySearch(param: String, category: String) {
        beerRepository.getBySearch(beerList, param, category)
    }

    fun getWheatBeers() {
        beerRepository.getWheatBeers(beerList)
    }

    fun getIPA() {
        beerRepository.getIPA(beerList)
    }

    fun getLagers() {
        beerRepository.getLagers(beerList)
    }

    fun getStouts() {
        beerRepository.getStouts(beerList)
    }
    //function that sends a beer item from AddItemFragment() to CollectionFragment() stored in AppDatabase()
    fun insert(beer: AddBeerItem){
        addBeerRepository.insert(beer)
    }
    fun search(id: Int){
        beerData = addBeerRepository.search(id)
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
    fun updateItem(beer: AddBeerItem){
        addBeerRepository.updateItem(beer)
    }
}