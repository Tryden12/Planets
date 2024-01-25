package com.tryden.planets.data

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.data.repository.DataRepository
import kotlinx.coroutines.flow.Flow

class FakePlanetsRepository : DataRepository {
    override fun getAllPlanets(): Flow<List<PlanetDto>> {
        return FakeDataSource.mockPlanetsListFlow
    }

    override suspend fun getPlanet(id: Int): PlanetDto {
        return FakeDataSource.mockPlanetDto
    }
}