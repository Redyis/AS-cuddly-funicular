package com.redyis.as_cuddly_funicular.di

import com.redyis.as_cuddly_funicular.data.api.CatalogApi
import com.redyis.as_cuddly_funicular.data.repository.AppRepositoryImpl
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAppRepository(
        impl: AppRepositoryImpl
    ): AppRepository

    companion object {
        private const val BASE_URL = "http://185.103.109.134/"

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        @Provides
        @Singleton
        fun provideCatalogApi(retrofit: Retrofit): CatalogApi {
            return retrofit.create(CatalogApi::class.java)
        }
    }
}
