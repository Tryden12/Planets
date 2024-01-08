package com.tryden.planets.data

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.data.remote.service.PlanetsApiService

/**
 * Repository that fetch planet list from PlanetsApi.
 */
interface PlanetsRepository {
    /** Fetches list of Planet from PlanetsApi */
    suspend fun getAllPlanets(): List<PlanetDto>

    /** Fetches a Planet from PlanetsApi */
    suspend fun getPlanet(): PlanetDto

}

/**
 * Network Implementation of Repository that fetch planet data from PlanetsApi.
 */
class NetworkPlanetsRepository(
    private val planetsApiService: PlanetsApiService
): PlanetsRepository {
    /** Fetches list of Planet from PlanetsApi */
    override suspend fun getAllPlanets(): List<PlanetDto> = planetsApiService.getAllPlanets()

    /** Fetches a Planet from PlanetsApi */
    override suspend fun getPlanet(): PlanetDto = planetsApiService.getPlanet()

}