package com.redyis.as_cuddly_funicular.domain.repository
import com.redyis.as_cuddly_funicular.domain.model.AppItem
interface AppRepository {
    fun getApps(): List<AppItem>
}