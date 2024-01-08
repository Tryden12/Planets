package com.tryden.planets.data.remote

import com.tryden.planets.data.Resource
import com.tryden.planets.data.remote.dto.PlanetDto

interface RemoteSource {

    suspend fun getAllPlanets(): Resource<List<PlanetDto>>

    suspend fun getPlanet(id: Int): Resource<PlanetDto>
}