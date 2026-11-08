package com.redyis.as_cuddly_funicular.data.dto

import com.google.gson.annotations.SerializedName

data class AppDto(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val category: String = "",
    @SerializedName("iconUrl")
    val iconUrl: String? = null,
    val icon: String? = null
)