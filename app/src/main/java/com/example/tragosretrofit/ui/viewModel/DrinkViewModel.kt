package com.example.tragosretrofit.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tragosretrofit.domain.GetDrinksUseCase
import com.example.tragosretrofit.domain.model.DomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val getDrinksUseCase: GetDrinksUseCase
): ViewModel() {

    val drinkLiveData = MutableLiveData<List<DomainModel>>()
    //creamos para el searchview
    val searchDrink = MutableLiveData<String>()

    //creamos una funcion para actualizar el livedata
    fun getDrinkByName(drink:String){
       searchDrink.value = drink
    }

    fun callUseCase() {
      viewModelScope.launch {
          val result = getDrinksUseCase()
          if (!result.isNullOrEmpty()){
              // devuelve todos los tragos
              drinkLiveData.value = result
          }
      }
    }
}
