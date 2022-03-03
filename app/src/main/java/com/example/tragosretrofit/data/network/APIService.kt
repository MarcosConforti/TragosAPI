package com.example.tragosretrofit.data.network

import com.example.tragosretrofit.data.model.DrinkModel
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("search.php?s=margarita")
    suspend fun getAllDrinks():Response<List<DrinkModel>>
}