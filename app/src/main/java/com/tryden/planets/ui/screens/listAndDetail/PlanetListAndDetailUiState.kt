package com.tryden.planets.ui.screens.listAndDetail

import com.tryden.planets.data.remote.dto.PlanetDto

/**
 * UI state for the Planets list and detail screen
 */
sealed interface PlanetListAndDetailUiState {
    data class Success(val planets: List<PlanetDto>, val planet: PlanetDto): PlanetListAndDetailUiState
    object Error: PlanetListAndDetailUiState
    object Loading: PlanetListAndDetailUiState
}