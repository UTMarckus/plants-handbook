package com.utmarckus.plantshandbook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utmarckus.plantshandbook.databinding.PlantItemBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    val plantList = mutableListOf<Plant>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantAdapter.PlantHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.plant_item,
                parent,
                false
            )
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantAdapter.PlantHolder, position: Int) =
        holder.bind(plantList[position])

    override fun getItemCount(): Int = plantList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }

    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {

        val binding = PlantItemBinding.bind(item)

        fun bind(plant: Plant) = with(binding) {
            imageView.setImageResource(plant.imgId)
            tvTitle.text = plant.title
            tvDescription.text = plant.description
        }
    }
}
