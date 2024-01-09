package com.tryden.planets.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tryden.planets.data.remote.RemoteDataSource
import com.tryden.planets.data.remote.RemoteSource
import com.tryden.planets.data.remote.service.PlanetsApiService
import com.tryden.planets.utils.Constants
import com.tryden.planets.utils.MyInterceptor
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
 * This is the Hilt NetworkModule class which provides the following dependencies:
 * retrofit, client, service and repositories
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Retrofit singleton.
     * Params: [url] [okHttpClient] [moshi] provided as singletons below.
     */
    @Provides
    @Singleton
    fun provideRetrofit(url: String, okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideUrl(): String {
        return Constants.BASE_URL
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun createClient(): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(MyInterceptor())
//            interceptors().add(MyInterceptor())
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