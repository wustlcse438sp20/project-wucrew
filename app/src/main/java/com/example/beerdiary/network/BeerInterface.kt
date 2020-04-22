package com.example.beerdiary.network

import com.example.beerdiary.data.Beer
import com.example.beerdiary.data.BeerPayload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerInterface {

    @GET("category/beers.json")
    suspend fun getBeer()
            : Response<BeerPayload>

    //@GET("cgi/search.pl?search_simple=1&action=process&json=1&category=beers&page_size=100")
    @GET("cgi/search.pl?search_simple=1&action=process&json=1&page_size=100")
    suspend fun getBySearch(@Query("search_terms") search_terms: String, @Query("category") category: String)
            : Response<BeerPayload>

    @GET("category/wheat-beers.json")
    suspend fun getWheatBeers()
            : Response<BeerPayload>

    @GET("category/india-pale-ale.json")
    suspend fun getIPA()
            : Response<BeerPayload>

    @GET("category/lagers.json")
    suspend fun getLagers()
            : Response<BeerPayload>

    @GET("category/stout.json")
    suspend fun getStouts()
            : Response<BeerPayload>
}