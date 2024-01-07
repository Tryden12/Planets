package com.tryden.planets.ui

import com.tryden.planets.data.local.LocalPlanetsDataProvider
import com.tryden.planets.domain.PlanetLocal

data class PlanetsUiStateOld(
    val planetsList: List<PlanetLocal> = emptyList(),
    val currentPlanetLocal: PlanetLocal = LocalPlanetsDataProvider.defaultPlanet,
    val isShowingListPage: Boolean = true
)
