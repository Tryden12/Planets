package com.tryden.planets.ui.screens.listAndDetail

import com.tryden.planets.data.remote.dto.PlanetResponse

/**
 * UI state for the Planets list and detail screen
 */
sealed interface PlanetListAndDetailUiState {
    data class Success(val planets: List<PlanetResponse>, val planet: PlanetResponse): PlanetListAndDetailUiState
    object Error: PlanetListAndDetailUiState
    object Loading: PlanetListAndDetailUiState
}