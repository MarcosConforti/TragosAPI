package com.example.tragosretrofit.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tragosretrofit.data.model.DrinkModel
import com.example.tragosretrofit.domain.GetDrinksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val getDrinksUseCase:GetDrinksUseCase) :ViewModel() {

    val drinkModel = MutableLiveData<DrinkModel>()

    fun callUseCase(){
      viewModelScope.launch {
          val result = getDrinksUseCase()
          if (!result.isNullOrEmpty()){
              //result0 = devolver el primer trago
            drinkModel.postValue(result[0])
          }
      }
    }
}