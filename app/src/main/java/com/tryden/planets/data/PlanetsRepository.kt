package com.tryden.planets.data

import com.tryden.planets.model.Planet
import com.tryden.planets.network.PlanetsApiService

/**
 * Repository that fetch planet list from PlanetsApi.
 */
interface PlanetsRepository {
    /** Fetches list of Planet from PlanetsApi */
    suspend fun getAllPlanets(): List<Planet>

    /** Fetches a Planet from PlanetsApi */
    suspend fun getPlanet(): Planet

}

/**
 * Network Implementation of Repository that fetch planet data from PlanetsApi.
 */
class NetworkPlanetsRepository(
    private val planetsApiService: PlanetsApiService
): PlanetsRepository {
    /** Fetches list of Planet from PlanetsApi */
    override suspend fun getAllPlanets(): List<Planet> = planetsApiService.getAllPlanets()

    /** Fetches a Planet from PlanetsApi */
    override suspend fun getPlanet(): Planet = planetsApiService.getPlanet()

}