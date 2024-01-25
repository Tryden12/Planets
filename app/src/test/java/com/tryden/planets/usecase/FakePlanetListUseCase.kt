package com.tryden.planets.usecase

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.data.repository.DataRepositoryImpl
import com.tryden.planets.domain.mapper.PlanetMapper
import io.kotest.matchers.shouldBe
import com.tryden.planets.domain.usecase.planetsList.PlanetsListUseCase
import com.tryden.planets.utils.CoroutineTestRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * This is the unit test class to test PlanetListUseCase.
 */
@ExperimentalCoroutinesApi
class FakePlanetListUseCase {

    lateinit var planetsListUseCase: PlanetsListUseCase
    lateinit var mapper: PlanetMapper

    private val dataRepository = mockk<DataRepositoryImpl>()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Before
    fun setup() {
        mapper = PlanetMapper()
        planetsListUseCase = PlanetsListUseCase(dataRepository, mapper)
    }

    @Test
    fun fetch_Planets_List() = runTest {
        // given
        val mockPlanetsList = mockk<List<PlanetDto>>(relaxed = true)

        every {
            dataRepository.getAllPlanets()
        } returns flow { emit(mockPlanetsList) }

        // when
        val useCaseValue = planetsListUseCase.getAllPlanets()

        // then
        useCaseValue.first() shouldBe mockPlanetsList
    }
}