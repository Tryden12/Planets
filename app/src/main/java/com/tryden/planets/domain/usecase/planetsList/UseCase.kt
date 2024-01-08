package com.tryden.planets.domain.usecase.planetsList

import com.tryden.planets.domain.model.Planet
import kotlinx.coroutines.flow.Flow

/**
 * Interface for the PlanetsListUseCase
 */
interface UseCase {

    fun getAllPlanets(): Flow<List<Planet>>
}