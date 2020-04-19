package com.example.beerdiary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(AddBeerItem::class), version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun addBeerDao(): AddBeerItemDao

    companion object{

        @Volatile   //retrieves from memory rather than from cache
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            val temp = INSTANCE
            if(temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}