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

    @GET("cgi/search.pl?search_simple=1&action=process&json=1&category=beers")
    suspend fun getBySearch(@Query("search_terms") search_terms: String)
            : Response<BeerPayload>
}