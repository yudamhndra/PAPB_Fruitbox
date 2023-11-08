package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding
import com.example.fruitbox.databinding.FruitsListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fruitsadapter = FruitAdapter(generateFruitsData()) {FruitList ->
            val intent = Intent(this@MainActivity, FruitDetailActivity::class.java)
            intent.putExtra("fruits_name", FruitList.fruitsName)
            intent.putExtra("fruits_family", FruitList.fruitsFamily)
            intent.putExtra("fruits_description", FruitList.fruitsDescription)
            intent.putExtra("fruits_pict", FruitList.fruitsPict)
            startActivity(intent)
        }
        with(binding) {
            rycFruit.apply {
                adapter = fruitsadapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateFruitsData(): List<FruitList>{
        return listOf(
            FruitList("Strawberry", "Rosaceae", R.drawable.strawberry, "The strawberry is a fruit plant that is a herb and is found in the sub-tropical region. It is a two-year plant that produces fruit only in certain areas, usually in highland. The plant is characterized by a short main stem, with leaves growing at each node. The internodes are very short, resulting in leaves being very close to each other. The plant is like a bush without a stem, and the main stem and the leaves that are tightly arranged are called the crown. The strawberry plant is a member of the Rosaceae family, which also includes other fruit plants such as apple, cherry, and pear."),
            FruitList("Mango", "Anacardiaceae", R.drawable.mango, "Mangoes are a tropical fruit from the cashew family, Anacardiaceae. They are also a drupe, which means they have a single large seed or stone in the middle. Sometimes called the “king of fruits,” mangoes are one of the most widely consumed fruits in the world.")
        )
    }
}