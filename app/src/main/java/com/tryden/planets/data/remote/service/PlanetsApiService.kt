package com.tryden.planets.data.remote.service

import com.tryden.planets.data.remote.dto.PlanetDto
import retrofit2.Response
import retrofit2.http.GET

/**
 * A public interface that exposes the get method(s).
 */
interface PlanetsApiService {

    /**
     * Returns a [List] of [PlanetDto] and this method can be called from a Coroutine.
     */
    @GET("planets")
    suspend fun getAllPlanets(): Response<List<PlanetDto>>

    /**
     * Returns a [PlanetDto] and this method can be called from a Coroutine.
     * The @GET annotation parameter [id] indicates the planet id.
     */
    @GET("id")
    suspend fun getPlanet(id: Int): Response<PlanetDto>
}