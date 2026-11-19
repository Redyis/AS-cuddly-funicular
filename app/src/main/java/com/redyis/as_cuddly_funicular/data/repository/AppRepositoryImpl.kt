package com.redyis.as_cuddly_funicular.data.repository

import com.redyis.as_cuddly_funicular.data.api.CatalogApi
import com.redyis.as_cuddly_funicular.data.mapper.AppMapper
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: CatalogApi,
    private val mapper: AppMapper
) : AppRepository {

    override suspend fun getApps(): List<AppItem> {
        return mapper.toDomainList(api.getCatalog())
    }


    override suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float> {
        val result = mutableMapOf<String, Float>()
        for (id in ids) {
            result[id] = api.getRating(id)
        }
        return result
    }


    override suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float> = coroutineScope {
        ids.map { id ->
            async { id to api.getRating(id) }
        }.awaitAll().toMap()
    }
}