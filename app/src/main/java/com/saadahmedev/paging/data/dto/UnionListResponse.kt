package com.saadahmedev.paging.data.dto

import com.google.gson.annotations.SerializedName

class UnionListResponse(
    @SerializedName("content")
    var unions: List<Union>? = null
) : BasePageResponse()