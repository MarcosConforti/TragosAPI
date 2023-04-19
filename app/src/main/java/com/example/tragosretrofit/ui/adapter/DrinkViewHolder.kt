package com.example.tragosretrofit.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tragosretrofit.databinding.ItemListDrinkBinding
import com.example.tragosretrofit.domain.model.DomainModel
import com.squareup.picasso.Picasso

class DrinkViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemListDrinkBinding.bind(view)

    fun render(listModel: DomainModel,onClickListener:(DomainModel)->Unit){
        binding.tvDrink.text = listModel.drinks
        binding.tvCategory.text = listModel.category
        binding.tvAlcohol.text = listModel.alcohol
        Picasso.get().load(listModel.image).into(binding.ivImage)

        itemView.setOnClickListener{onClickListener(listModel)}
    }
}