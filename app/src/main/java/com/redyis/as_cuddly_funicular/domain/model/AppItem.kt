package com.redyis.as_cuddly_funicular.domain.model

import androidx.annotation.DrawableRes

data class AppItem(
    val id: String = "",
    @param:DrawableRes val iconRes: Int,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String? = null
)