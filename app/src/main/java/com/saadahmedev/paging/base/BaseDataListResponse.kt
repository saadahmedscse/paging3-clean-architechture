package com.saadahmedev.paging.base

import com.google.gson.annotations.SerializedName

abstract class BaseDataListResponse<T>(
    @SerializedName("data")
    val data: List<T>? = null
) : BasePageResponse()