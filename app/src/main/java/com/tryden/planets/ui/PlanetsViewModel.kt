package com.tryden.planets.ui

import androidx.lifecycle.ViewModel
import com.tryden.planets.data.LocalPlanetsDataProvider
import com.tryden.planets.model.Planet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


/**
 * View Model for Planets app
 */
class PlanetsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        PlanetsUiState(
            planetsList = LocalPlanetsDataProvider.getPlanetsData(),
            currentPlanet = LocalPlanetsDataProvider.getPlanetsData().getOrElse(0) {
                LocalPlanetsDataProvider.defaultPlanet
            }
        )
    )
    val uiState: StateFlow<PlanetsUiState> = _uiState

    fun updateCurrentPlanet(selectedPlanet: Planet) {
        _uiState.update {
            it.copy(
                currentPlanet = selectedPlanet
            )
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }

}