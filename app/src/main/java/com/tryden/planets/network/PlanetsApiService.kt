package com.tryden.planets.network

import com.tryden.planets.data.remote.dto.PlanetResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * A public interface that exposes the get method(s).
 */
interface PlanetsApiService {

    /**
     * Returns a [List] of [PlanetResponse] and this method can be called from a Coroutine.
     */
    @GET("planets")
    suspend fun getAllPlanets(): Response<List<PlanetResponse>>

    /**
     * Returns a [PlanetResponse] and this method can be called from a Coroutine.
     * The @GET annotation parameter [id] indicates the planet id.
     */
    @GET("id")
    suspend fun getPlanet(id: Int): Response<PlanetResponse>
}