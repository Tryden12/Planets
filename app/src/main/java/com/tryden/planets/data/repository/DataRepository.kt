package com.tryden.planets.data.repository

import com.tryden.planets.domain.model.Planet
import kotlinx.coroutines.flow.Flow

/**
 * In order to have a clean architecture, I have created this interface
 * and implementing it in DataRepositoryImpl class.
 */
interface DataRepository {

    fun getAllPlanets(): Flow<List<Planet>>

    suspend fun getPlanet(id: Int): Planet?
}