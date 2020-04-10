package com.example.beerdiary.network

import com.example.beerdiary.data.BeerPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerInterface {

    @GET("category/beers.json")
    suspend fun getBeer()
            : Response<BeerPayload>

    @GET("search")
    suspend fun getBySearch(@Query("q") q: String)
            : Response<BeerPayload>
}