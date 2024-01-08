package com.tryden.planets.domain.usecase.planetsList

import com.tryden.planets.data.repository.DataRepository
import com.tryden.planets.domain.model.Planet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Following the clean architecture, this is the use case class for planets list.
 * This use case is later injected to the view model wherever it is required.
 */
class PlanetsListUseCase @Inject constructor(
    private val dataRepository: DataRepository
): UseCase {
    override fun getAllPlanets(): Flow<List<Planet>> {
        return dataRepository.getAllPlanets()
    }

}