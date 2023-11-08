package com.example.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitbox.databinding.FruitsActivityBinding

class FruitDetailActivity : AppCompatActivity() {

    private lateinit var binding: FruitsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FruitsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitsName = intent.getStringExtra("fruits_name").toString()
        val fruitsDescription = intent.getStringExtra("fruits_description").toString()
        val fruitsfamily = intent.getStringExtra("fruits_family").toString()
        val fruitspict = intent.getIntExtra("fruits_pict", 0)

        with(binding){
            txtFruitsName.text = fruitsName
            txtFruitsDesc.text = fruitsDescription
            txtFruitsFamily.text = fruitsfamily
            imgFruits.setImageResource(fruitspict)

        }

    }
}