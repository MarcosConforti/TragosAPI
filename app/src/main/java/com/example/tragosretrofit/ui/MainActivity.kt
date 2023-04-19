package com.example.tragosretrofit.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tragosretrofit.R
import com.example.tragosretrofit.databinding.ActivityMainBinding
import com.example.tragosretrofit.domain.model.DomainModel
import com.example.tragosretrofit.ui.adapter.DrinkAdapter
import com.example.tragosretrofit.ui.viewModel.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DrinkAdapter
    private val drinkViewModel:DrinkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drinkViewModel.callUseCase()

        drinkViewModel.drinkLiveData.observe(this, androidx.lifecycle.Observer {
            initRecycler(it)
        })
    }

    private fun initRecycler(drinks: List<DomainModel>) {
        binding.rvDrinks.layoutManager = LinearLayoutManager(this)
        // faltaba inicializar el adapter
        adapter = DrinkAdapter(drinks) { domainModel ->  onItemClick(domainModel) }
        binding.rvDrinks.adapter = adapter
    }
    private fun onItemClick(domainModel: DomainModel){
        val intent = Intent(this,ActivityDescription::class.java)
        intent.putExtra("drink",domainModel.drinks)
        intent.putExtra("instructions",domainModel.instructions)
        intent.putExtra("image",domainModel.image)
        intent.putExtra("category",domainModel.category)
        intent.putExtra("alcohol",domainModel.alcohol)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val item = menu.findItem(R.id.search)
        val searchView = item.actionView as SearchView
        searchView.queryHint = "Search by name"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        return true
    }
}