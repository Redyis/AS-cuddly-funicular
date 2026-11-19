package com.redyis.as_cuddly_funicular.domain.repository
import com.redyis.as_cuddly_funicular.domain.model.AppItem
interface AppRepository {
    suspend fun getApps(): List<AppItem>

    suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float>
    suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float>
}