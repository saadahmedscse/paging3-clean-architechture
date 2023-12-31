package com.saadahmedev.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.saadahmedev.paging.dto.BaseContentListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

object PagingSource {

    fun <T : Any, R : BaseContentListResponse<T>> getData(
        scope: CoroutineScope,
        function: suspend (page: Int, size: Int) -> R,
        loadingState: MutableLiveData<Boolean>,
        size: Int = 10
    ): Flow<PagingData<T>> =
        Pager(
            PagingConfig(
                pageSize = 1
            )
        ) {
            BasePagingSource(function, loadingState, size)
        }.flow.cachedIn(scope)

}