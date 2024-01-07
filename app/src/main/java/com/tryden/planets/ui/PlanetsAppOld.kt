package com.tryden.planets.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tryden.planets.R
import com.tryden.planets.ui.appbar.PlanetsAppBar
import com.tryden.planets.ui.screens.detail.PlanetsDetail
import com.tryden.planets.ui.screens.list.PlanetsList
import com.tryden.planets.ui.screens.listAndDetail.PlanetsListAndDetail
import com.tryden.planets.utils.PlanetsContentType

/**
 * Main composable that serves as a container
 * which displays content according to [uiState] and [windowSize]
 */
@Composable
fun PlanetsAppOld(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit
) {
    // We utilizing a ViewModel.Factory for manual DI
    val viewModel: PlanetsViewModel = viewModel(factory = PlanetsViewModel.Factory)
    val uiState by viewModel.uiState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> PlanetsContentType.ListOnly
        WindowWidthSizeClass.Expanded -> PlanetsContentType.ListAndDetail
        else -> PlanetsContentType.ListOnly
    }

    Scaffold(
        topBar = {
            PlanetsAppBar(
                onBackButtonClick = { viewModel.navigateToListPage() },
                isShowingListPage = uiState.isShowingListPage,
                windowSize = windowSize
            )
        }
    ) { innerPadding ->
        if (contentType == PlanetsContentType.ListAndDetail) {
             PlanetsListAndDetail(
                 planetLocals = uiState.planetsList,
                 selectedPlanetLocal = uiState.currentPlanetLocal,
                 onClick = {
                     viewModel.updateCurrentPlanet(it)
                 },
                 onBackPressed = onBackPressed,
                 contentPadding = innerPadding,
                 modifier = Modifier.fillMaxWidth()
             )
        } else {
            if (uiState.isShowingListPage) {
                PlanetsList(
                    planetLocals = uiState.planetsList,
                    onClick = {
                        viewModel.updateCurrentPlanet(it)
                        viewModel.navigateToDetailPage()
                    },
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    contentPadding = innerPadding
                )
            } else {
                 PlanetsDetail(
                     selectedPlanetLocal = uiState.currentPlanetLocal,
                     contentPadding = innerPadding,
                     onBackPressed = {
                         viewModel.navigateToListPage()
                     }
                 )
            }
        }
    }
}

