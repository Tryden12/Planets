package com.tryden.planets.domain.usecase.planet

import com.tryden.planets.domain.model.Planet

/**
 * Interface for the PlanetUseCase
 */
interface UseCase {

    suspend fun getPlanet(id: Int): Planet?
}