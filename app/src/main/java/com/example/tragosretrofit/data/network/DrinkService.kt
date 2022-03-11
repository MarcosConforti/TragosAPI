package com.example.tragosretrofit.data.network

import com.example.tragosretrofit.data.model.DrinkModel
import kotlinx.coroutines.*
import javax.inject.Inject

class DrinkService @Inject constructor(private val apiService: APIService) {

    suspend fun getDrinks(): List<DrinkModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getAllDrinks()
            response.body()?.drinks ?: emptyList()
        }
    }
}