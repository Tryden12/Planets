package com.tryden.planets

import com.tryden.planets.data.FakeDataSource
import com.tryden.planets.domain.model.Planet
import com.tryden.planets.domain.usecase.planetsList.PlanetsListUseCase
import com.tryden.planets.ui.PlanetsViewModel
import com.tryden.planets.ui.screens.list.PlanetsListUiState
import com.tryden.planets.utils.CoroutineTestRule
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PlanetsViewModelTest {

    private lateinit var viewModel: PlanetsViewModel

    private val planetsListUseCase = mockk<PlanetsListUseCase>()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Before
    fun setup() {
        // empty body, view model should be initialized with mocking applied
    }

    @Test
    fun planetsViewModel_getPlanetsList_success()  = runTest {
        // given
        val planet = mockk<Planet>()

        every { planetsListUseCase.getAllPlanets() } returns flow {
            emit(listOf(planet, planet, planet))
        }

        // when
        // view model is initialized
        viewModel = PlanetsViewModel(planetsListUseCase)

        // then
        viewModel.uiState.value.planets.size shouldBe 3
        viewModel.uiState.value.isLoading shouldBe false
    }

    @Test
    fun planetsViewModel_getPlanetsList_failed() = runTest {
        // given
        every { planetsListUseCase.getAllPlanets() } returns flow {
            emit(emptyList())
        }

        // when
        // view model is initialized
        viewModel = PlanetsViewModel(planetsListUseCase)

        // then
        viewModel.uiState.value.planets.size shouldBe 0
        viewModel.uiState.value.isLoading shouldBe false
    }
}