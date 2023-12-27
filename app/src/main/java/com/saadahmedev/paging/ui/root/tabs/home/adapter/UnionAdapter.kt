package com.saadahmedev.paging.ui.root.tabs.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.saadahmedev.paging.databinding.ItemUnionBinding
import com.saadahmedev.paging.domain.model.UnionResponse

class UnionAdapter : PagingDataAdapter<UnionResponse, UnionAdapter.UnionViewHolder>(UnionDiffCallback()) {

    inner class UnionViewHolder(private val binding: ItemUnionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(union: UnionResponse) {
            binding.item = union
        }
    }

    class UnionDiffCallback : DiffUtil.ItemCallback<UnionResponse>() {
        override fun areItemsTheSame(oldItem: UnionResponse, newItem: UnionResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UnionResponse, newItem: UnionResponse): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: UnionViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnionViewHolder {
        return UnionViewHolder(ItemUnionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}