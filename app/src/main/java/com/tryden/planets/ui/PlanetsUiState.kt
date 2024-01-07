package com.tryden.planets.ui

import com.tryden.planets.data.LocalPlanetsDataProvider
import com.tryden.planets.model.PlanetLocal

data class PlanetsUiState(
    val planetsList: List<PlanetLocal> = emptyList(),
    val currentPlanetLocal: PlanetLocal = LocalPlanetsDataProvider.defaultPlanet,
    val isShowingListPage: Boolean = true
)
