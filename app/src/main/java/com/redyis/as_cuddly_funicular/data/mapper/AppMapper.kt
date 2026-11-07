package com.redyis.as_cuddly_funicular.data.mapper

import com.redyis.as_cuddly_funicular.data.dto.AppDto
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import javax.inject.Inject
class AppMapper @Inject constructor() {
    fun toDomain(dto: AppDto): AppItem {
        return AppItem(
            name = dto.name,
            category = dto.category,
            iconRes = dto.iconRes,
            description = dto.description
        )
    }

    fun toDomainList(dtoList: List<AppDto>): List<AppItem> {
        return dtoList.map { toDomain(it) }
    }
}