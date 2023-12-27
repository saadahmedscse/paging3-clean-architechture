package com.saadahmedev.paging.base

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.Serializable

abstract class BasePageResponse(

    @SerializedName("totalPages")
    var totalPages: Int? = null,

    @SerializedName("totalElements")
    var totalElements: Long? = null,

    @SerializedName("last")
    var last: Boolean? = null,

    @SerializedName("size")
    var size: Int? = null,

    @SerializedName("numberOfElements")
    var numberOfElements: Int? = null,

    @SerializedName("number")
    var number: Int? = null,

    @SerializedName("first")
    var first: Boolean? = null,

    @SerializedName("empty")
    var empty: Boolean? = null

) : Serializable {

    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }

}