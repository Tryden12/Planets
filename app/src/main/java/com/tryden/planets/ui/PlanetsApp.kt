package com.tryden.planets.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tryden.planets.R
import com.tryden.planets.ui.appbar.PlanetsAppBar
import com.tryden.planets.ui.screens.detail.PlanetsDetail
import com.tryden.planets.ui.screens.list.PlanetsList
import com.tryden.planets.ui.screens.list.PlanetsListUiState
import com.tryden.planets.ui.screens.listAndDetail.PlanetsListAndDetail
import com.tryden.planets.utils.PlanetsContentType

/**
 * Main composable that serves as a container
 * which displays content according to [uiState] and [windowSize]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetsApp(
    windowSize: WindowWidthSizeClass,
    onBackPressed: () -> Unit
) {
    // We utilizing a ViewModel.Factory for manual DI
    val viewModel: PlanetsViewModel = viewModel(factory = PlanetsViewModel.Factory)
    val uiState by viewModel.planetsListUiState.collectAsState()
//    val uiState: PlanetsListUiState = viewModel.planetsListUiState
    when (uiState) {
        is PlanetsUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is PlanetsUiState.Success -> PhotosGridScreen(marsUiState.photos, modifier = modifier)
        is PlanetsUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
    }
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> PlanetsContentType.ListOnly
        WindowWidthSizeClass.Expanded -> PlanetsContentType.ListAndDetail
        else -> PlanetsContentType.ListOnly
    }

    Scaffold(
        modifier = Modifier,
        topBar = { PlanetsAppBar(
            onBackButtonClick = { viewModel.navigateToListPage() },
            isShowingListPage = true, // todo
            windowSize = windowSize
        ) }
    ) { innerPadding ->
        if (contentType == PlanetsContentType.ListAndDetail) {
            // todo
//             PlanetsListAndDetail(
//                 planetLocals = uiState.planetsList,
//                 selectedPlanetLocal = uiState.currentPlanetLocal,
//                 onClick = {
//                     viewModel.updateCurrentPlanet(it)
//                 },
//                 onBackPressed = onBackPressed,
//                 contentPadding = innerPadding,
//                 modifier = Modifier.fillMaxWidth()
//             )
        } else {
            when (uiState) {
                is PlanetsUiState.Loading -> {

                }// todo LoadingScreen()
                is PlanetsUiState.Success -> {
                    if ((uiState as PlanetsUiState.Success).isShowingListPage) {
                        PlanetsList(
                            planets = (uiState as PlanetsUiState.Success).planets,
                            onClick = {
                                viewModel.updateCurrentPlanet(it)
                                viewModel.navigateToDetailPage()
                            },
                            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                            contentPadding = innerPadding
                        )
                    }
                }
                is PlanetsUiState.Error -> {

                }// todo ErrorScreen()
            }






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

/**
 * The home screen displaying the loading message.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

