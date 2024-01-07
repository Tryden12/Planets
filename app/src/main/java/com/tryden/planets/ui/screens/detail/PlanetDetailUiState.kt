package com.tryden.planets.ui.screens.detail

import com.tryden.planets.data.remote.dto.PlanetResponse

/**
 * UI state for the Planets detail screen
 */
sealed interface PlanetDetailUiState {
    data class Success(val planet: PlanetResponse): PlanetDetailUiState
    object Error: PlanetDetailUiState
    object Loading: PlanetDetailUiState
}