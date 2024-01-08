package com.tryden.planets.ui.screens.list

import com.tryden.planets.data.remote.dto.PlanetDto

/**
 * UI state for the Home screen
 */
sealed interface PlanetsListUiState {
    data class Success(val planets: List<PlanetDto>): PlanetsListUiState
    object Error: PlanetsListUiState
    object Loading: PlanetsListUiState
}