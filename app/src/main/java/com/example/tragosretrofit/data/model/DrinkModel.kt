package com.example.tragosretrofit.data.model

import com.google.gson.annotations.SerializedName

data class DrinkModel(
    @SerializedName("strDrink")val drinks:String,
    @SerializedName("strCategory")val category:String,
    @SerializedName("strAlcoholic")val alcohol:String,
    @SerializedName("strInstructions")val instructions:String,
    @SerializedName("strDrinkThumb")val image:String
    ) {
}



