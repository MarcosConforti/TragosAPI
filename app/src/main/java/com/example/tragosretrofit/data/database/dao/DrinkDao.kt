package com.example.tragosretrofit.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tragosretrofit.data.database.entities.DrinkEntities

@Dao
interface DrinkDao {
    @Query("SELECT * FROM drink_table")
    suspend fun getAllDrinks():List<DrinkEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drinks:List<DrinkEntities>)

    @Query("DELETE FROM drink_table")
    suspend fun deleteAllDrinks()
}