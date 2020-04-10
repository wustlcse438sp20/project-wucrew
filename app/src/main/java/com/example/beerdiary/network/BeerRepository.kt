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
}