package com.example.tragosretrofit.data

import com.example.tragosretrofit.data.model.DrinkModel
import com.example.tragosretrofit.data.model.DrinkProvider
import com.example.tragosretrofit.data.network.DrinkService
import javax.inject.Inject
//el repositorio define si accede a la lista desde retrofit o desde db
//en este caso, solo llamara a retrofit, por lo tanto a la clase DrinkService
class DrinkRepository @Inject constructor(
    private val api:DrinkService,
    private val drinkProvider: DrinkProvider) {

    suspend fun getDrinks(): List<DrinkModel> {
        //recupero los tragos
        val response: List<DrinkModel> = api.getDrinks()
        //almaceno la respuesta del servidor, simulando una db
        drinkProvider.drink = response
        return response
    }
}