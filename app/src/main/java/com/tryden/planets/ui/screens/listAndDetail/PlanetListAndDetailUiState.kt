package com.tryden.planets.ui.screens.listAndDetail

import com.tryden.planets.model.Planet

/**
 * UI state for the Planets list and detail screen
 */
sealed interface PlanetListAndDetailUiState {
    data class Success(val planets: List<Planet>, val planet: Planet): PlanetListAndDetailUiState
    object Error: PlanetListAndDetailUiState
    object Loading: PlanetListAndDetailUiState
}