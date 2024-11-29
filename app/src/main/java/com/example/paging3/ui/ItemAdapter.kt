package com.example.paging3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paging3.data.local.Item
import com.example.paging3.data.remote.model.response.charachter.Result
import com.example.paging3.databinding.ItemRowBinding

class ItemAdapter : PagingDataAdapter<Result, ItemAdapter.ItemViewHolder>(ItemDiffCallback()) {

    class ItemViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result?) {
            binding.characterNameTextView.text = item?.name
            val imageUrl = "${item?.thumbnail?.path}.${item?.thumbnail?.extension}"
            Glide.with(binding.characterImageView.context)
                .load(imageUrl)
                .into(binding.characterImageView)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ItemViewHolder(binding)
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
}
