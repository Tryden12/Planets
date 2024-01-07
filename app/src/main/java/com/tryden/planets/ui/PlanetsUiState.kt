package com.tryden.planets.ui

import com.tryden.planets.data.remote.dto.PlanetResponse

interface PlanetsUiState {
    data class Success(
        val planets: List<PlanetResponse>,
        var currentPlanet: PlanetResponse,
        val isShowingListPage: Boolean = true
    ): PlanetsUiState
    object Error: PlanetsUiState
    object Loading: PlanetsUiState
}
