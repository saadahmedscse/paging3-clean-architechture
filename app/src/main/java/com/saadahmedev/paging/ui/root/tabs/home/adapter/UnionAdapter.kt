package com.saadahmedev.paging.ui.root.tabs.home.adapter

import com.saadahmedev.paging.R
import com.saadahmedev.paging.base.BasePagingAdapter
import com.saadahmedev.paging.data.dto.Union
import com.saadahmedev.paging.databinding.ItemUnionBinding

class UnionAdapter : BasePagingAdapter<Union, ItemUnionBinding>() {

    override val layoutRes: Int
        get() = R.layout.item_union

    override fun onBind(binding: ItemUnionBinding, item: Union?, position: Int) {
        binding.item = item
    }
}