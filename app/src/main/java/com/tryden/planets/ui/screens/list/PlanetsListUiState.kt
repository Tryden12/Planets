package com.tryden.planets.ui.screens.list

import com.tryden.planets.model.Planet

/**
 * UI state for the Home screen
 */
sealed interface PlanetsListUiState {
    data class Success(val planets: List<Planet>): PlanetsListUiState
    object Error: PlanetsListUiState
    object Loading: PlanetsListUiState
}