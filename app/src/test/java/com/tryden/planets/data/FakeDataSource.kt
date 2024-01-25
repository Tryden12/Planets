package com.tryden.planets.data

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.domain.model.Planet
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

object FakeDataSource {

    val mockPlanetsListResponse = mockk<Response<List<PlanetDto>>>(relaxed = true)
    val mockPlanetsListFlow = mockk<Flow<List<PlanetDto>>>(relaxed = true)
    val mockPlanetsList = mockk<List<Planet>>(relaxed = true)

    val mockPlanetResponse = mockk<Response<PlanetDto>>(relaxed = true)
    val mockPlanetDto = mockk<PlanetDto>(relaxed = true)
    val mockPlanet = mockk<Planet>(relaxed = true)

}