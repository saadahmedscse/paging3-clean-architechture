package com.saadahmedev.paging.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.saadahmedev.paging.domain.model.UnionResponse

data class Union(

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name_en")
    @Expose
    var name: String? = null,

    @SerializedName("name_bn")
    @Expose
    var nameBn: String? = null,

    @SerializedName("upazila_id")
    @Expose
    var upazilaId: Int? = null,

    @SerializedName("bbs_code")
    @Expose
    var bbsCode: Int? = null,

    @SerializedName("created_at")
    var createdAt: Long? = null,

    @SerializedName("last_updated")
    var lastUpdated: Long? = null

) {
    fun toResponse(): UnionResponse =
        UnionResponse(
            id = id,
            name = name,
            nameBn = nameBn,
            upazilaId = upazilaId,
            bbsCode = bbsCode
        )
}