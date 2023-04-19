package com.example.tragosretrofit.data.network

import com.example.tragosretrofit.data.model.DrinksResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("search.php?s=")
    suspend fun getAllDrinks(): Response<DrinksResponse>
}