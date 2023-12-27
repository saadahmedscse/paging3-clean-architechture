package com.saadahmedev.paging.data.source

import com.saadahmedev.paging.data.dto.UnionListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CmedApi {

    @GET("v6/unions")
    suspend fun getUnions(@Query("page") page: Int, @Query("size") size: Int): UnionListResponse
}