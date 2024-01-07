package com.tryden.planets.ui.screens.detail

import com.tryden.planets.model.Planet

/**
 * UI state for the Planets detail screen
 */
sealed interface PlanetDetailUiState {
    data class Success(val planet: Planet): PlanetDetailUiState
    object Error: PlanetDetailUiState
    object Loading: PlanetDetailUiState
}