package com.saadahmedev.paging.domain.repository

import com.saadahmedev.paging.data.dto.UnionListResponse

interface CmedRepository {

    suspend fun getUnions(page: Int, size: Int): UnionListResponse
}