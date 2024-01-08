package com.tryden.planets.ui.screens.list

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.domain.model.Planet

/**
 * UI state for the Home screen
 */
data class PlanetsListUiState(
    var planets: List<Planet> = emptyList(),
    val isLoading: Boolean = true,
    var currentPlanet: Planet = Planet(),
    val isShowingListPage: Boolean = true
)