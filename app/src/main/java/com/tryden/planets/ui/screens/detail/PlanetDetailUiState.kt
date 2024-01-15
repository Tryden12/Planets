package com.tryden.planets.ui.screens.detail

import com.tryden.planets.data.remote.dto.PlanetDto

/**
 * UI state for the Planets detail screen
 */
sealed interface PlanetDetailUiState {
    data class Success(val planet: PlanetDto): PlanetDetailUiState
    object Error: PlanetDetailUiState
    object Loading: PlanetDetailUiState
}