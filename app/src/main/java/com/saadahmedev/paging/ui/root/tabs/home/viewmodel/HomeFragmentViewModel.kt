package com.saadahmedev.paging.ui.root.tabs.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saadahmedev.paging.domain.model.UnionResponse
import com.saadahmedev.paging.domain.useCase.CmedUseCase
import com.saadahmedev.paging.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val cmedUseCase: CmedUseCase) : ViewModel() {

    private val _unionList = MutableLiveData<ResponseState<List<UnionResponse>>>()
    val unionList: LiveData<ResponseState<List<UnionResponse>>>
        get() = _unionList

    fun getUnions(page: Int, size: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            cmedUseCase(page, size).collect {
                _unionList.postValue(it)
            }
        }
    }
}