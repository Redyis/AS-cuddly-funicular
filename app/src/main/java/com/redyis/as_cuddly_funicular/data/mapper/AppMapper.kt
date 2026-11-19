package com.redyis.as_cuddly_funicular.data.mapper

import com.redyis.as_cuddly_funicular.R
import com.redyis.as_cuddly_funicular.data.dto.AppDto
import com.redyis.as_cuddly_funicular.domain.model.AppItem
import javax.inject.Inject

class AppMapper @Inject constructor() {

    fun toDomain(dto: AppDto): AppItem {
        return AppItem(
            id = dto.id,
            iconRes = R.drawable.vk_play,
            name = dto.name,
            description = dto.description,
            category = dto.category,
            iconUrl = dto.iconUrl ?: dto.icon
        )
    }

    fun toDomainList(dtoList: List<AppDto>): List<AppItem> {
        return dtoList.map { toDomain(it) }
    }
}