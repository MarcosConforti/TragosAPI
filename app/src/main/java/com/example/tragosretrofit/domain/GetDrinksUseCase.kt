package com.example.tragosretrofit.domain

import com.example.tragosretrofit.data.DrinkRepository
import com.example.tragosretrofit.data.model.DrinkModel
import javax.inject.Inject

class GetDrinksUseCase @Inject constructor(private val repository: DrinkRepository) {

    suspend operator fun invoke() =  repository.getDrinks()
}