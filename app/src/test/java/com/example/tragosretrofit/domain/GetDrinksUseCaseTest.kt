package com.example.tragosretrofit.domain

import com.example.tragosretrofit.data.DrinkRepository
import com.example.tragosretrofit.domain.model.DomainModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDrinksUseCaseTest{

  @RelaxedMockK
  private lateinit var repository: DrinkRepository

  lateinit var getDrinksUseCase: GetDrinksUseCase

  @Before
  fun onBefore(){
      MockKAnnotations.init(this)
      getDrinksUseCase = GetDrinksUseCase(repository)
  }
    @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {
        //en el primero va el mockk
        //Given
        coEvery { repository.getDrinksFromApi() }returns emptyList()
        //When
        getDrinksUseCase()
        //Then
        coVerify(exactly = 1) { repository.getDrinksFromDataBase() }
    }
    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(DomainModel("mojito","drink","alcohol",
            "drink please","image"))
       coEvery { repository.getDrinksFromApi() } returns myList
        //When
        val response = getDrinksUseCase()
        //Then
        coVerify(exactly = 1) {repository.cleanListDrink()}
        coVerify(exactly = 1) { repository.insertDrinks(any())}
        coVerify(exactly = 0){ repository.getDrinksFromDataBase() }
        assert(myList == response)
    }
}