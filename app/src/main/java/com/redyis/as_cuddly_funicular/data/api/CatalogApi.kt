package com.redyis.as_cuddly_funicular.data.api

import com.redyis.as_cuddly_funicular.data.dto.AppDto
import retrofit2.http.GET
import retrofit2.http.Path
import kotlinx.coroutines.delay

interface CatalogApi{
    @GET("catalog")
    suspend fun getCatalog(): List<AppDto>

    @GET("{id}")
    suspend fun getAppDetails(
        @Path("id") id: String
    ): AppDto

    suspend fun getRating(id: String): Float {
        delay(1500)
        return (30..50).random() / 10f
    }
}