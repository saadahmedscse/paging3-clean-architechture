package com.saadahmedev.paging.ui.root.tabs.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.saadahmedev.paging.domain.model.UnionResponse
import com.saadahmedev.paging.domain.repository.CmedRepository
import com.saadahmedev.paging.domain.useCase.CmedUseCase
import com.saadahmedev.paging.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val cmedRepository: CmedRepository) : ViewModel() {
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    fun getUnions() = Pager(
        PagingConfig(
            pageSize = 1
        )
    ) {
        CmedUseCase(cmedRepository, _loadingState)
    }.flow.cachedIn(viewModelScope)
}