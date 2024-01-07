package com.tryden.planets.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tryden.planets.data.NetworkPlanetsRepository
import com.tryden.planets.data.PlanetsRepository
import com.tryden.planets.network.PlanetsApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val planetsRepository: PlanetsRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer: AppContainer {
    private val baseUrl = "https://planets-info-by-newbapi.p.rapidapi.com/api/v1/planets/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        // todo: add headers: api key, host
        .build()


    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: PlanetsApiService by lazy {
        retrofit.create(PlanetsApiService::class.java)
    }

    /**
     * DI implementation for Planets repository
     */
    override val planetsRepository: PlanetsRepository by lazy {
        NetworkPlanetsRepository(retrofitService)
    }

}







// OkHttp:
//val client = OkHttpClient()
//
//val request = Request.Builder()
//    .url("https://planets-info-by-newbapi.p.rapidapi.com/api/v1/planets/")
//    .get()
//    .addHeader("X-RapidAPI-Key", "13a44ed739msh8578ea5034fbd7cp1e5572jsn3c5106c8b3a6")
//    .addHeader("X-RapidAPI-Host", "planets-info-by-newbapi.p.rapidapi.com")
//    .build()
//
//val response = client.newCall(request).execute()