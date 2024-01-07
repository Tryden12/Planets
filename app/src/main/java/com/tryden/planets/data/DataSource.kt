package com.tryden.planets.data

import com.tryden.planets.domain.Planet
import kotlinx.coroutines.flow.Flow

interface DataSource {

    fun getAllPlanets(): Flow<List<Planet>>

    suspend fun getPlanet(id: Int): Planet
}