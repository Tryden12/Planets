package com.tryden.planets.ui

import com.tryden.planets.data.LocalPlanetsDataProvider
import com.tryden.planets.model.Planet

data class PlanetsUiState(
    val planetsList: List<Planet> = emptyList(),
    val currentPlanet: Planet = LocalPlanetsDataProvider.defaultPlanet,
    val isShowingListPage: Boolean = true
)
