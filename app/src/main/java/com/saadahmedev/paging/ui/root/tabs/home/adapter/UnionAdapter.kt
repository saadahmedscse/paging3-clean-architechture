package com.saadahmedev.paging.ui.root.tabs.home.adapter

import com.saadahmedev.paging.R
import com.saadahmedev.paging.base.BasePagingAdapter
import com.saadahmedev.paging.databinding.ItemUnionBinding
import com.saadahmedev.paging.domain.model.UnionResponse

class UnionAdapter : BasePagingAdapter<UnionResponse, ItemUnionBinding>() {

    override val layoutRes: Int
        get() = R.layout.item_union

    override fun onBind(binding: ItemUnionBinding, item: UnionResponse?, position: Int) {
        binding.item = item
    }
}