package com.example.tragosretrofit.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tragosretrofit.data.DrinkRepository
import com.example.tragosretrofit.domain.model.DomainModel

@Entity(tableName = "drink_table")
data class DrinkEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "drink") val drinks: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "alcohol") val alcohol: String,
    @ColumnInfo(name = "instructions") val instructions: String,
    @ColumnInfo(name = "image") val image: String,
)

fun DomainModel.toDataBase() = DrinkEntities(
    drinks = drinks,
    category = category,
    alcohol = alcohol,
    instructions = instructions,
    image = image
)
