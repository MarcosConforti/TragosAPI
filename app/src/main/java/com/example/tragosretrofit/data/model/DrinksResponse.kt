package com.example.tragosretrofit.data.model

import com.google.gson.annotations.SerializedName

// Esta clase representa la respuesta de la api, ya que los tragos llegan dentro de un objeto llamdo drinks en el Json
data class DrinksResponse(
    @SerializedName("drinks") val drinks: List<DrinkModel>
)
