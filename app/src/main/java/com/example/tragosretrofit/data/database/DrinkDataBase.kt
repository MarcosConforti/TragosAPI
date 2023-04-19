package com.example.tragosretrofit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tragosretrofit.data.database.dao.DrinkDao
import com.example.tragosretrofit.data.database.entities.DrinkEntities

@Database (entities = [DrinkEntities::class], version = 1)
abstract class DrinkDataBase:RoomDatabase() {
    abstract fun getDrinkDao():DrinkDao
}