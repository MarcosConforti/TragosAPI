package com.example.tragosretrofit.data

import com.example.tragosretrofit.data.database.dao.DrinkDao
import com.example.tragosretrofit.data.database.entities.DrinkEntities
import com.example.tragosretrofit.data.model.DrinkModel
import com.example.tragosretrofit.data.model.DrinkProvider
import com.example.tragosretrofit.data.network.DrinkService
import com.example.tragosretrofit.domain.model.DomainModel
import com.example.tragosretrofit.domain.model.toDomain
import javax.inject.Inject
//el repositorio define si accede a la lista desde retrofit o desde db
//en este caso, solo llamara a retrofit, por lo tanto a la clase DrinkService
//crear una interfaz en la capa de dominion que sea dirnksRepository
class DrinkRepository @Inject constructor(
    private val api:DrinkService,
    private val drinkDao: DrinkDao) {

    suspend fun getDrinksFromApi(): List<DomainModel> {
        //recupero los tragos
        val response: List<DrinkModel> = api.getDrinks()
        //mapeo
        return response.map { it.toDomain() }
    }
    suspend fun getDrinksFromDataBase():List<DomainModel>{
        val response = drinkDao.getAllDrinks()
        return response.map{it.toDomain()}
    }

    suspend fun insertDrinks(drinks: List<DrinkEntities>) {
        drinkDao.insertAll(drinks)
    }

    suspend fun cleanListDrink() {
        drinkDao.deleteAllDrinks()
    }
}