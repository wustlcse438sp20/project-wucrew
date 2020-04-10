package com.example.beerdiary.data

data class Beer(
    val product_name: String,
    val image_front_url: String
)

data class BeerPayload(
    val products : List<Beer>
)