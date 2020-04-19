package com.example.beerdiary.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beers")
data class AddBeerItem(
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "type")
    val type : String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "rating")
    val rating : Float,
    @ColumnInfo(name = "manufacturer")
    val manufacturer : String,
    @ColumnInfo(name = "country")
    val country : String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}