package com.saadahmedev.paging.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<VB: ViewDataBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)