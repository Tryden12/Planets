package com.tryden.planets.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.PlanetsTheme
import com.tryden.planets.R
import com.tryden.planets.data.LocalPlanetsDataProvider
import com.tryden.planets.model.Planet


/**
 * Composable that displays both the list of planets and the details of the selected planet.
 *
 * This composable is only shown on large screens.
 */
@Composable
fun PlanetsListAndDetail(
    planets: List<Planet>,
    selectedPlanet: Planet,
    onClick: (Planet) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(
        modifier = modifier
    ) {
        PlanetsList(
            planets = planets,
            onClick = onClick,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding()
            ),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        )
        PlanetsDetail(
            selectedPlanet = selectedPlanet,
            onBackPressed = onBackPressed,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding()
            ),
            modifier = Modifier.weight(3f)
        )
    }
}

@Preview(device = Devices.TABLET)
@Composable
fun PlanetsListAndDetailsPreview() {
    PlanetsTheme {
        Surface {
            PlanetsListAndDetail(
                planets = LocalPlanetsDataProvider.getPlanetsData(),
                selectedPlanet = LocalPlanetsDataProvider.getPlanetsData().getOrElse(0){
                    LocalPlanetsDataProvider.defaultPlanet
                },
                onClick = {},
                onBackPressed = {})
        }
    }
}