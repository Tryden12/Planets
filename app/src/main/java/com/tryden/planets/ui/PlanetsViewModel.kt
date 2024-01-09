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
class PlanetsViewModel : ViewModel() {



}