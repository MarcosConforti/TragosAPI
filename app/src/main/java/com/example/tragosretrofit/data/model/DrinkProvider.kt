package com.example.tragosretrofit.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkProvider @Inject constructor(){

    var drink: List<DrinkModel> = emptyList()
}