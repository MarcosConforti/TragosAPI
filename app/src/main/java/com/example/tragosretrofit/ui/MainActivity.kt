package com.example.tragosretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tragosretrofit.data.model.DrinkModel
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


        drinkViewModel.callUseCase()

        drinkViewModel.drinkLiveData.observe(this, Observer {
            initRecycler(it)
        })


    }
    private fun initRecycler(drinks: List<DrinkModel>) {
        binding.rvDrinks.layoutManager = LinearLayoutManager(this)

        // faltaba inicializar el adapter
        adapter = DrinkAdapter(drinks)

        binding.rvDrinks.adapter = adapter
    }
}