package com.redyis.as_cuddly_funicular

import androidx.annotation.DrawableRes

data class AppItem(
    @DrawableRes val iconRes: Int,
    val name: String,
    val description: String,
    val category: String
)