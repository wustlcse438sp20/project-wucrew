package com.example.beerdiary.network

import androidx.lifecycle.MutableLiveData
import com.example.beerdiary.data.Beer
import com.example.beerdiary.data.BeerPayload
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response

class BeerRepository {
    val service = APIClient.makeRetrofitService()

    fun getBeer(resBody: MutableLiveData<List<Beer>>) {
        CoroutineScope(Dispatchers.IO).launch {
            lateinit var response: Response<BeerPayload>

            response = service.getBeer()

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        resBody.value = response.body()?.products
                    }
                } catch (e: HttpException) {
                    println("Http Error")
                }
            }
        }
    }

    fun getBySearch(resBody: MutableLiveData<List<Beer>>, param: String, category: String) {
        CoroutineScope(Dispatchers.IO).launch {
            lateinit var response: Response<BeerPayload>

            response = service.getBySearch(param, category)

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        resBody.value = response.body()?.products
                    }
                } catch (e: HttpException) {
                    println("Http Error")
                }
            }
        }
    }

    fun getWheatBeers(resBody: MutableLiveData<List<Beer>>) {
        CoroutineScope(Dispatchers.IO).launch {
            lateinit var response: Response<BeerPayload>

            response = service.getWheatBeers()

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        resBody.value = response.body()?.products
                    }
                } catch (e: HttpException) {
                    println("Http Error")
                }
            }
        }
    }

    fun getIPA(resBody: MutableLiveData<List<Beer>>) {
        CoroutineScope(Dispatchers.IO).launch {
            lateinit var response: Response<BeerPayload>

            response = service.getIPA()

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        resBody.value = response.body()?.products
                    }
                } catch (e: HttpException) {
                    println("Http Error")
                }
            }
        }
    }
    fun getLagers(resBody: MutableLiveData<List<Beer>>) {
        CoroutineScope(Dispatchers.IO).launch {
            lateinit var response: Response<BeerPayload>

            response = service.getLagers()

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        resBody.value = response.body()?.products
                    }
                } catch (e: HttpException) {
                    println("Http Error")
                }
            }
        }
    }

    fun getStouts(resBody: MutableLiveData<List<Beer>>) {
        CoroutineScope(Dispatchers.IO).launch {
            lateinit var response: Response<BeerPayload>

            response = service.getStouts()

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        resBody.value = response.body()?.products
                    }
                } catch (e: HttpException) {
                    println("Http Error")
                }
            }
        }
    }
}