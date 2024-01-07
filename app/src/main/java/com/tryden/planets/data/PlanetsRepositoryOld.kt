package com.tryden.planets.data

import com.tryden.planets.data.remote.dto.PlanetResponse
import com.tryden.planets.network.PlanetsApiService
import javax.inject.Inject

/**
 * Repository that fetch planet list from PlanetsApi.
 */
interface PlanetsRepository {
    /** Fetches list of Planet from PlanetsApi */
    suspend fun getAllPlanets(): List<PlanetResponse>

    /** Fetches a Planet from PlanetsApi */
    suspend fun getPlanet(): PlanetResponse

}

/**
 * Network Implementation of Repository that fetch planet data from PlanetsApi.
 */
class NetworkPlanetsRepository(
    private val planetsApiService: PlanetsApiService
): PlanetsRepository {
    /** Fetches list of Planet from PlanetsApi */
    override suspend fun getAllPlanets(): List<PlanetResponse> = planetsApiService.getAllPlanets()

    /** Fetches a Planet from PlanetsApi */
    override suspend fun getPlanet(): PlanetResponse = planetsApiService.getPlanet()

}