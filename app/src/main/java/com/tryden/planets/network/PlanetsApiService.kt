package com.tryden.planets.network

import com.tryden.planets.model.Planet
import retrofit2.http.GET

/**
 * A public interface that exposes the get method(s).
 */
interface PlanetsApiService {

    /**
     * Returns a [List] of [Planet] and this method can be called from a Coroutine.
     */
    @GET
    suspend fun getAllPlanets(): List<Planet>

    /**
     * Returns a [Planet] and this method can be called from a Coroutine.
     * The @GET annotation parameter [id] indicates the planet id.
     */
    @GET("id")
    suspend fun getPlanet(): Planet
}