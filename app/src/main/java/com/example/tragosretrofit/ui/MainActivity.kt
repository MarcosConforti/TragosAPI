package com.example.tragosretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tragosretrofit.databinding.ActivityMainBinding
import com.example.tragosretrofit.ui.recyclerView.DrinkAdapter
import com.example.tragosretrofit.ui.viewModel.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DrinkAdapter
    private val drinkViewModel:DrinkViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        drinkViewModel.callUseCase()

        drinkViewModel.drinkModel.observe(this, Observer { binding.rvDrinks  })


    }
    private fun initRecycler(){
       binding.rvDrinks.layoutManager = LinearLayoutManager(this)
        binding.rvDrinks.adapter = adapter
    }
}