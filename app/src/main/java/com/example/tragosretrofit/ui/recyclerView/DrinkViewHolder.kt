package com.example.tragosretrofit.ui.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tragosretrofit.databinding.ItemListDrinkBinding
import com.example.tragosretrofit.data.model.DrinkModel
import com.squareup.picasso.Picasso

class DrinkViewHolder (view:View):RecyclerView.ViewHolder(view) {

  private val binding = ItemListDrinkBinding.bind(view)

    fun render(listModel: DrinkModel){
        binding.tvDrink.text = listModel.drinks
        binding.tvCategory.text = listModel.category
        binding.tvAlcohol.text = listModel.alcohol
        Picasso.get().load(listModel.image).into(binding.ivImage)
    }
}