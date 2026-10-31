package com.redyis.as_cuddly_funicular.data.repository

import com.redyis.as_cuddly_funicular.data.datasource.MockAppDataSource
import com.redyis.as_cuddly_funicular.data.mapper.AppMapper
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository

class AppRepositoryImpl(
    private val dataSource: MockAppDataSource = MockAppDataSource(),
    private val mapper: AppMapper = AppMapper()
) : AppRepository {
    override fun getApps(): List<AppItem> {
        return dataSource.getApps().map { mapper.toDomain(it) }
    }
}