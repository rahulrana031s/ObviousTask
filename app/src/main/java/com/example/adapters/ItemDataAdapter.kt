package com.example.obvioustask.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.obvioustask.R
import com.example.obvioustask.databinding.ItemViewBinding
import com.example.obvioustask.model.ItemData

class ItemDataAdapter(
    private var items: MutableList<ItemData>,
    private val onClick: (Int) -> Unit,
    private val onFavClick: (Int) -> Unit
) : RecyclerView.Adapter<ItemDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding, onClick, onFavClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, items[position])
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<ItemData>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemViewBinding,
        private val onClick: (Int) -> Unit,
        private val onFavClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, item: ItemData) {
            binding.apply {
                apodTitle.text = item.title

                Glide.with(itemView)
                    .load(item.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(apodImage)

                containerCard.setOnClickListener { onClick(position) }
            }
        }
    }
}