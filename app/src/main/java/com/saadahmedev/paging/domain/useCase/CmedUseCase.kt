package com.saadahmedev.paging.domain.useCase

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.saadahmedev.paging.domain.model.UnionResponse
import com.saadahmedev.paging.domain.repository.CmedRepository

//class CmedUseCase(private val cmedRepository: CmedRepository, private val loadingState: MutableLiveData<Boolean>) : PagingSource<Int, UnionResponse>() {
//
//    override fun getRefreshKey(state: PagingState<Int, UnionResponse>): Int? {
//        return state.anchorPosition?.let {
//            state.closestPageToPosition(it)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnionResponse> {
//        val page = params.key ?: 1
//        loadingState.postValue(true)
//
//        return try {
//            val response = cmedRepository.getUnions(page, 10)
//
//            loadingState.postValue(false)
//            LoadResult.Page(
//                data = response.unions?.map { it.toResponse() } ?: emptyList(),
//                prevKey = if (page == 1) null else page - 1,
//                nextKey = if (page == response.totalPages) null else page + 1
//            )
//        } catch (e: Exception) {
//            loadingState.postValue(false)
//            LoadResult.Error(e)
//        }
//    }
//}