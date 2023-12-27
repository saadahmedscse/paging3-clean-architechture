package com.saadahmedev.paging.base

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState

class BasePagingSource<T : Any, R : BaseContentListResponse<T>>(
    private val function: suspend (page: Int, size: Int) -> R,
    private val loadingState: MutableLiveData<Boolean>,
    private val size: Int = 10
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: 1
        loadingState.postValue(true)

        return try {
            val response = function.invoke(page, size)

            loadingState.postValue(false)
            LoadResult.Page(
                data = response.data ?: emptyList(),
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (page == response.totalPages) null else page + 1
            )
        } catch (e: Exception) {
            loadingState.postValue(false)
            LoadResult.Error(e)
        }
    }
}