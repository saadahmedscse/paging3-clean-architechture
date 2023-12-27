package com.saadahmedev.paging.ui.root.tabs.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.saadahmedev.paging.base.BasePagingSource
import com.saadahmedev.paging.base.PagingSource
import com.saadahmedev.paging.domain.repository.CmedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val cmedRepository: CmedRepository) : ViewModel() {
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    fun getUnions() = PagingSource.getData(viewModelScope, cmedRepository::getUnions, _loadingState)
}