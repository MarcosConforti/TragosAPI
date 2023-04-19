package com.example.tragosretrofit.domain

import com.example.tragosretrofit.data.DrinkRepository
import com.example.tragosretrofit.data.database.entities.toDataBase
import com.example.tragosretrofit.data.model.DrinkModel
import com.example.tragosretrofit.domain.model.DomainModel
import javax.inject.Inject

//se llama solamente cuando se inicia la app, recupera los datos del servidor
class GetDrinksUseCase @Inject constructor(private val repository: DrinkRepository){

    suspend operator fun invoke():List<DomainModel>{
        val drink = repository.getDrinksFromApi()
       return if(drink.isNotEmpty()){
           repository.cleanListDrink()
           repository.insertDrinks(drink.map { it.toDataBase() })
           drink
        }else{
            //si esta vacio, que recupere los datos de la db
            repository.getDrinksFromDataBase()
        }
    }
}