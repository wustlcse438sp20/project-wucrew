package com.example.beerdiary.data

data class BeerPayload(
    val products : List<Beer>
)

data class Beer(
    val product_name: String,
    val image_front_url: String,
    val nutriments: Nutriments
)

data class Nutriments(
    val energy_value : Int
)