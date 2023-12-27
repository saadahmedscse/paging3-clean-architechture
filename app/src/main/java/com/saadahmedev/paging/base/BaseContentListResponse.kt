package com.saadahmedev.paging.base

import com.google.gson.annotations.SerializedName

abstract class BaseContentListResponse<T>(
    @SerializedName("content")
    val data: List<T>? = null
) : BasePageResponse()