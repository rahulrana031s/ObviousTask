package com.example.obvioustask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.obvioustask.R
import com.example.obvioustask.databinding.DetailsItemBinding
import com.example.obvioustask.model.ItemData

class DetailsItemAdapter(
    private val items: List<ItemData>,
) : RecyclerView.Adapter<DetailsItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(private val binding: DetailsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemData) {
            binding.apply {
                title.text = item.title
                item.copyright?.let {
                    copyright.text = "© $it"
                    copyright.visibility = View.VISIBLE
                }
                date.text = item.date
                explanation.text = item.explanation


                Glide.with(itemView)
                    .load(item.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image)
            }
        }
    }
}