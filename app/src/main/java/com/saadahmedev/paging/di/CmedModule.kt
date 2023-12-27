package com.saadahmedev.paging.di

import com.saadahmedev.paging.data.repository.CmedRepositoryImpl
import com.saadahmedev.paging.data.source.CmedApi
import com.saadahmedev.paging.domain.repository.CmedRepository
import com.saadahmedev.paging.util.AppConstants.Api.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CmedModule {

    @Singleton
    @Provides
    fun provideCmedApi(): CmedApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CmedApi::class.java)

    @Singleton
    @Provides
    fun provideCmedRepository(cmedApi: CmedApi): CmedRepository = CmedRepositoryImpl(cmedApi)
}