package com.tryden.planets.ui

import com.tryden.planets.data.remote.dto.PlanetDto

interface PlanetsUiState {
    data class Success(
        val planets: List<PlanetDto>,
        var currentPlanet: PlanetDto,
        val isShowingListPage: Boolean = true
    ): PlanetsUiState
    object Error: PlanetsUiState
    object Loading: PlanetsUiState
}
