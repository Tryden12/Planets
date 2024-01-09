package com.tryden.planets.di

import com.tryden.planets.data.remote.RemoteDataSource
import com.tryden.planets.data.remote.RemoteSource
import com.tryden.planets.data.remote.service.PlanetsApiService
import com.tryden.planets.utils.MyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * This is the Hilt NetworkModule class which provides the retrofit, client, service and repositories dependencies.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun createClient(): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(MyInterceptor())
        }.build()
        return client
    }

    @Provides
    @Singleton
    fun providePlanetsService(retrofit: Retrofit): PlanetsApiService {
        return retrofit.create(PlanetsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteRepository(api: PlanetsApiService): RemoteSource {
        return RemoteDataSource(api)
    }
}