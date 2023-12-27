package com.saadahmedev.paging.base

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.saadahmedev.paging.databinding.ItemUnionBinding
import com.saadahmedev.paging.ui.root.tabs.home.adapter.UnionAdapter

abstract class BasePagingAdapter<T : Any, VB : ViewDataBinding> :
    PagingDataAdapter<T, BaseViewHolder<VB>>(PagingDiffCallback()) {

    @get: LayoutRes
    abstract val layoutRes: Int

    abstract fun onBind(binding: VB, item: T?, position: Int)

    class PagingDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        onBind(holder.binding, getItem(position), position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder<VB>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    )
}