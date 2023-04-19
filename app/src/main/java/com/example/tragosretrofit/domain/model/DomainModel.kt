package com.example.tragosretrofit.domain.model

import com.example.tragosretrofit.data.database.entities.DrinkEntities
import com.example.tragosretrofit.data.model.DrinkModel

data class DomainModel(
    val drinks:String,
    val category:String,
    val alcohol:String,
    val instructions:String,
    val image:String
) {
}

//funcion de extension para realizar los mapers
fun DrinkModel.toDomain() = DomainModel(drinks, category, alcohol,instructions, image)
fun DrinkEntities.toDomain() = DomainModel(drinks, category, alcohol,instructions, image)
