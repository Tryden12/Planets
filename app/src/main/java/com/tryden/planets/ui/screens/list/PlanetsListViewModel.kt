package com.tryden.planets.ui.screens.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tryden.planets.domain.model.Planet
import com.tryden.planets.domain.model.PlanetLocal
import com.tryden.planets.domain.usecase.planetsList.PlanetsListUseCase
import com.tryden.planets.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import javax.inject.Inject


/**
 * Here we prepare all provided from the data & domain layers for the UI, presentation layer.
 * This class has no knowledge whether data is coming from API or Database,
 * so fulfilling complete abstraction of Data Layer.
 * We are using Flow to keep the data stream unidirectional.
 */
@HiltViewModel
class PlanetsListViewModel @Inject constructor(
    private val planetsListUseCase: PlanetsListUseCase
): BaseViewModel() {



    private val _uiState = MutableStateFlow(PlanetsListUiState())
    val uiState: StateFlow<PlanetsListUiState> = _uiState


//    var uiState by mutableStateOf(PlanetsListUiState())
//        private set

    init {
        getPlanetsList()
    }

    fun getPlanetsList() {
        // CoroutineScope tied to this ViewModel
        // Scope will be cleared when ViewModel will be cleared
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            planetsListUseCase.getAllPlanets().collect() { result ->
                if (result.isNotEmpty()) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            planets = result,
                            currentPlanet = result[0]
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(isLoading = false, planets = result)
                    }
                }
            }
        }
    }

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