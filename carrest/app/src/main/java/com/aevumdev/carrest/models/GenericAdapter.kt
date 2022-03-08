package com.aevumdev.carrest.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aevumdev.carrest.R
import com.aevumdev.carrest.databinding.SinglelistitemBinding

class GenericAdapter(
    private val list: List<Car>,
    private val onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<GenericAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SinglelistitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding, onItemClicked)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.modelText.text = this.model
                binding.priceText.text = this.price.toString()
            }
        }
    }

    inner class ViewHolder(val binding: SinglelistitemBinding, val onItemClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View) {
            val position = bindingAdapterPosition
            onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
       return list.count()
    }
}

