package com.example.beerdiary.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object APIClient {
    const val BASE_URL = "https://us.openfoodfacts.org/"

    fun makeRetrofitService(): BeerInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(BeerInterface::class.java)
    }
}