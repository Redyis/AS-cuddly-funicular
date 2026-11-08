package com.redyis.as_cuddly_funicular.data.repository

import com.redyis.as_cuddly_funicular.data.api.CatalogApi
import com.redyis.as_cuddly_funicular.data.mapper.AppMapper
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: CatalogApi,
    private val mapper: AppMapper
) : AppRepository {

    override suspend fun getApps(): List<AppItem> {
        val dtoList = api.getCatalog()
        return mapper.toDomainList(dtoList)
    }
}