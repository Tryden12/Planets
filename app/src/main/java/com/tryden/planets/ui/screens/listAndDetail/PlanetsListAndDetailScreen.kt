package com.tryden.planets.ui.screens.listAndDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.tryden.planets.R
import com.tryden.planets.domain.model.Planet
import com.tryden.planets.ui.screens.detail.PlanetsDetailScreen
import com.tryden.planets.ui.screens.list.PlanetsListScreen
import com.tryden.planets.utils.PlanetsContentType


/**
 * Composable that displays both the list of planets and the details of the selected planet.
 *
 * This composable is only shown on large screens.
 */
@Composable
fun PlanetsListAndDetail(
    planets: List<Planet>,
    selectedPlanet: Planet,
    contentType: PlanetsContentType,
    onClick: (Planet) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(
        modifier = modifier
    ) {
        PlanetsListScreen(
            planets = planets,
            onClick = onClick,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding()
            ),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        )
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .width(.5.dp)
                .background(MaterialTheme.colorScheme.onBackground)
        )
        PlanetsDetailScreen(
            planet = selectedPlanet,
            onBackPressed = onBackPressed,
            contentType = contentType,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding()
            ),
            modifier = Modifier.weight(3f)
        )
    }
}

//@Preview(device = Devices.TABLET)
//@Composable
//fun PlanetsListAndDetailsPreview() {
//    PlanetsTheme {
//        Surface {
//            PlanetsListAndDetail(
//                planet = LocalPlanetsDataProvider.getPlanetsData(),
//                selectedPlanet = LocalPlanetsDataProvider.getPlanetsData().getOrElse(0){
//                    LocalPlanetsDataProvider.defaultPlanet
//                },
//                onClick = {},
//                onBackPressed = {})
//        }
//    }
//}