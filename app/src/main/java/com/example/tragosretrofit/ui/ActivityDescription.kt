package com.example.tragosretrofit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tragosretrofit.databinding.ActivityDescriptionBinding
import com.squareup.picasso.Picasso

class ActivityDescription : AppCompatActivity() {

    private lateinit var binding: ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }
    fun getData(){
        val drink:String = intent.getStringExtra("drink").toString()
        val instructions:String = intent.getStringExtra("instructions").toString()
        val image:String = intent.getStringExtra("image").toString()
        val category:String = intent.getStringExtra("category").toString()
        val alcohol:String = intent.getStringExtra("alcohol").toString()

        binding.tvName.text = drink
        binding.tvDescription.text = instructions
        binding.tvCategory.text = category
        binding.tvAlcohol.text = alcohol
        Picasso.get().load(image).into(binding.ivImage)
    }

}