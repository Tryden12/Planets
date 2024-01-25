package com.tryden.planets.data

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.data.remote.service.PlanetsApiService
import retrofit2.Response

class FakePlanetsApiService : PlanetsApiService {
    override suspend fun getAllPlanets(): Response<List<PlanetDto>> {
        return FakeDataSource.mockPlanetsListResponse
    }

    override suspend fun getPlanet(id: Int): Response<PlanetDto> {
        return FakeDataSource.mockPlanetResponse
    }


}