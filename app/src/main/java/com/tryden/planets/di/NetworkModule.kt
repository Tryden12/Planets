package com.tryden.planets.di

import com.tryden.planets.data.remote.RemoteDataSource
import com.tryden.planets.data.remote.RemoteSource
import com.tryden.planets.data.remote.service.PlanetsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
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
    fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor { chain -> return@addInterceptor addHeadersToRequests(chain) }
        return okHttpClientBuilder.build()
    }

    private fun addHeadersToRequests(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("X-RapidAPI-Key", "13a44ed739msh8578ea5034fbd7cp1e5572jsn3c5106c8b3a6")
            .addQueryParameter("X-RapidAPI-Host", "planets-info-by-newbapi.p.rapidapi.com")
            .build()
        request.url(newUrl)
        return chain.proceed(request.build())
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