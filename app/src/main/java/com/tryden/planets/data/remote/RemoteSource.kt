package com.tryden.planets.data.remote

import com.tryden.planets.data.Resource
import com.tryden.planets.data.remote.dto.PlanetResponse
import com.tryden.planets.domain.Planet

interface RemoteSource {

    suspend fun getAllPlanets(): Resource<List<PlanetResponse>>

    suspend fun getPlanet(id: Int): Resource<PlanetResponse>
}