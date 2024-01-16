package com.tryden.planets.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
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
import com.tryden.planets.ui.screens.ErrorScreen
import com.tryden.planets.ui.screens.LoadingScreen
import com.tryden.planets.ui.screens.detail.PlanetsDetailScreen
import com.tryden.planets.ui.screens.list.PlanetsListScreen
import com.tryden.planets.ui.screens.list.PlanetsListViewModel
import com.tryden.planets.ui.screens.listAndDetail.PlanetsListAndDetail
import com.tryden.planets.utils.PlanetsContentType

/**
 * Main composable that serves as a container
 * which displays content according to [uiState] and [windowSize]
 */
@Composable
fun PlanetsApp(
    viewModel: PlanetsListViewModel,
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit
) {
    // Instantiate ViewModel and set key variables
    val uiState by viewModel.uiState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> PlanetsContentType.ListOnly
        WindowWidthSizeClass.Expanded -> PlanetsContentType.ListAndDetail
        else -> PlanetsContentType.ListOnly
    }
    val retryAction = viewModel::getPlanetsList

    // Build the app
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
            // Load screen based on uiState
            when (uiState.isLoading) {
                true -> LoadingScreen(modifier = Modifier.fillMaxSize())
                false -> {
                    // If planets list is empty, show ErrorScreen()
                    // Else show PlanetsListAndDetail()
                    if (uiState.planets.isEmpty()){
                        ErrorScreen(retryAction, modifier = Modifier.fillMaxSize())
                    } else {
                        PlanetsListAndDetail(
                            planets = uiState.planets,
                            selectedPlanet = uiState.currentPlanet,
                            contentType = contentType,
                            onClick = {
                                viewModel.updateCurrentPlanet(it)
                            },
                            onBackPressed = onBackPressed,
                            contentPadding = innerPadding,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

        } else {
            // Load screen based on uiState
            when (uiState.isLoading) {
                true -> LoadingScreen(modifier = Modifier.fillMaxSize())
                false -> {
                    // If planets list is empty, show ErrorScreen()
                    // Else show PlanetsListScreen() or PlanetsDetailsScreen()
                    if (uiState.planets.isEmpty()){
                        ErrorScreen(retryAction, modifier = Modifier.fillMaxSize())
                    } else if (uiState.isShowingListPage) {
                        PlanetsListScreen(
                            planets = uiState.planets,
                            onClick = {
                                viewModel.updateCurrentPlanet(it)
                                viewModel.navigateToDetailPage()
                            },
                            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                            contentPadding = innerPadding
                        )
                    } else {
                        PlanetsDetailScreen(
                            planet = uiState.currentPlanet,
                            contentPadding = innerPadding,
                            contentType = contentType,
                            onBackPressed = {
                                viewModel.navigateToListPage()
                            }
                        )
                    }
                }
            }
        }
    }
}

