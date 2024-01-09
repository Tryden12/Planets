package com.tryden.planets.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.tryden.planets.PlanetsApplication
import com.tryden.planets.data.local.LocalPlanetsDataProvider
import com.tryden.planets.domain.model.PlanetLocal
import com.tryden.planets.ui.screens.detail.PlanetDetailUiState
import com.tryden.planets.ui.screens.list.PlanetsListUiState
import com.tryden.planets.ui.screens.listAndDetail.PlanetListAndDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


/**
 * View Model for Planets app
 */
//class PlanetsViewModelOld(
//    private val planetsRepository: PlanetsRepository
//) : ViewModel() {
//
//    /**
//     * Factory for [PlanetsViewModelOld] that takes [PlanetsRepository] as a dependency
//     */
//    companion object {
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PlanetsApplication)
//                val planetsRepository = application.container.planetsRepository
//                PlanetsViewModelOld(planetsRepository = planetsRepository)
//            }
//        }
//    }
//
//    /** The mutable State that stores the status of the most recent request */
//
////    private val _planetsUiState = MutableStateFlow(PlanetsUiState.Loading)
////    val planetsUiState: StateFlow<PlanetsUiState> = _planetsUiState
//
//    var planetsListUiState: PlanetsListUiState by mutableStateOf(PlanetsListUiState.Loading)
//        private set
//
//    var planetDetailUiState: PlanetDetailUiState by mutableStateOf(PlanetDetailUiState.Loading)
//        private set
//
//    var planetsListAndDetailUiState: PlanetListAndDetailUiState by mutableStateOf(
//        PlanetListAndDetailUiState.Loading
//    )
//        private set
//
//
//    /**
//     * Call getAllPlanets() on init so we can display status immediately.
//     */
//    init {
//        getAllPlanets()
//
//        // TODO: add getPlanet() if PlanetListAndDetailScreen is showing
//    }
//
//    /**
//     * Gets planets information from the Planets API Retrofit service and updates the
//     * [Planet] [List] [MutableList].
//     */
//    fun getAllPlanets() {
//        viewModelScope.launch {
//            planetsListUiState = PlanetsListUiState.Loading
//            planetsListUiState = try {
//                val planets = planetsRepository.getAllPlanets()
//                PlanetsListUiState.Success(planets)
//            } catch (e: IOException) {
//                PlanetsListUiState.Error
//            } catch (e: HttpException) {
//                PlanetsListUiState.Error
//            }
//
//        }
//    }
//
//    /**
//     * Gets planet detail information from the Planets API Retrofit service and updates the
//     * [Planet].
//     */
//    fun getPlanet() {
//        viewModelScope.launch {
//            planetDetailUiState = PlanetDetailUiState.Loading
//            planetDetailUiState = try {
//                PlanetDetailUiState.Success(planetsRepository.getPlanet())
//            } catch (e: IOException) {
//                PlanetDetailUiState.Error
//            } catch (e: HttpException) {
//                PlanetDetailUiState.Error
//            }
//        }
//    }
//
//
//    /**
//     * Deprecated: PlanetsViewModel utilizing LocalPlanetsDataProvider
//     */
//    private val _uiStateOld = MutableStateFlow(
//        PlanetsUiStateOld(
//            planetsList = LocalPlanetsDataProvider.getPlanetsData(),
//            currentPlanetLocal = LocalPlanetsDataProvider.getPlanetsData().getOrElse(0) {
//                LocalPlanetsDataProvider.defaultPlanet
//            }
//        )
//    )
//    val uiStateOld: StateFlow<PlanetsUiStateOld> = _uiStateOld
//
//    fun updateCurrentPlanet(selectedPlanetLocal: PlanetLocal) {
//        _uiStateOld.update {
//            it.copy(
//                currentPlanetLocal = selectedPlanetLocal
//            )
//        }
//    }
//
//    fun navigateToListPage() {
//        _uiStateOld.update {
//            it.copy(isShowingListPage = true)
//        }
//    }
//
//    fun navigateToDetailPage() {
//        _uiStateOld.update {
//            it.copy(isShowingListPage = false)
//        }
//    }
//
//}