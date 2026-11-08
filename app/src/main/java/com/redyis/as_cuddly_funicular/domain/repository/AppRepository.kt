package com.redyis.as_cuddly_funicular.domain.repository
import com.redyis.as_cuddly_funicular.domain.model.AppItem
interface AppRepository {
    suspend fun getApps(): List<AppItem>
}