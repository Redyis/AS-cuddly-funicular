package com.redyis.as_cuddly_funicular.di

import com.redyis.as_cuddly_funicular.data.repository.AppRepositoryImpl
import com.redyis.as_cuddly_funicular.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAppRepository(
        impl: AppRepositoryImpl
    ): AppRepository
}