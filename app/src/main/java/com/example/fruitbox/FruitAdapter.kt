package com.example.fruitbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import com.example.fruitbox.databinding.FruitsListBinding

typealias OnClickFruits = (FruitList) -> Unit

class FruitAdapter(private val fruitsList : List<FruitList>, private val onClickFruits: (FruitList) -> Unit) :
    RecyclerView.Adapter<FruitAdapter.FruitItemViewHolder>() {

        inner class FruitItemViewHolder(val binding: FruitsListBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: FruitList) {
                with(binding) {
                    fruitName.text = data.fruitsName
                    fruitFamily.text = data.fruitsFamily

                    itemView.setOnClickListener {
                        onClickFruits(data)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitItemViewHolder {
        val binding = FruitsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: FruitItemViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(fruit)
        holder.binding.pictFruit.setImageResource(fruit.fruitsPict)

        holder.itemView.setOnClickListener {
            onClickFruits(fruit)
            val toastMessage = "You selected: ${fruit.fruitsName}"
            Toast.makeText(holder.itemView.context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}