package com.tryden.planets.domain.usecase.planet

import com.tryden.planets.data.repository.DataRepository
import com.tryden.planets.domain.model.Planet
import javax.inject.Inject

/**
 * Following the clean architecture, this is the use case class for planets list.
 * This use case is later injected to the view model wherever it is required.
 */
class PlanetUseCase @Inject constructor(
    private val dataRepository: DataRepository
): UseCase {
    override suspend fun getPlanet(id: Int): Planet? {
        return dataRepository.getPlanet(id)
    }
}