package com.saadahmedev.paging.data.repository

import com.saadahmedev.paging.data.dto.UnionListResponse
import com.saadahmedev.paging.data.source.CmedApi
import com.saadahmedev.paging.domain.repository.CmedRepository
import javax.inject.Inject

class CmedRepositoryImpl @Inject constructor(private val cmedApi: CmedApi) : CmedRepository {

    override suspend fun getUnions(page: Int, size: Int): UnionListResponse = cmedApi.getUnions(page, size)
}