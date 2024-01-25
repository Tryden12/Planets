package com.tryden.planets

import com.tryden.planets.data.FakeDataSource
import com.tryden.planets.domain.usecase.planetsList.PlanetsListUseCase
import com.tryden.planets.ui.PlanetsViewModel
import com.tryden.planets.ui.screens.list.PlanetsListUiState
import com.tryden.planets.utils.CoroutineTestRule
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class PlanetsViewModelTest {

    private val planetsListUseCase = mockk<PlanetsListUseCase>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun planetsViewModel_getPlanetsList_verifyPlanetsUiStateSuccess() {
        runTest {
            val planetsViewModel = PlanetsViewModel(
                planetsListUseCase = planetsListUseCase
            )
            assertEquals(
                PlanetsListUiState(planets = FakeDataSource.mockPlanetsList),
                planetsViewModel.uiState
            )
        }
    }
}