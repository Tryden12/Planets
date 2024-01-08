package com.tryden.planets.ui.screens.listAndDetail

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
import com.tryden.planets.data.local.LocalPlanetsDataProvider
import com.tryden.planets.domain.model.PlanetLocal
import com.tryden.planets.ui.screens.detail.PlanetsDetail
import com.tryden.planets.ui.screens.list.PlanetsList


/**
 * Composable that displays both the list of planets and the details of the selected planet.
 *
 * This composable is only shown on large screens.
 */
@Composable
fun PlanetsListAndDetail(
    planetLocals: List<PlanetLocal>,
    selectedPlanetLocal: PlanetLocal,
    onClick: (PlanetLocal) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Row(
        modifier = modifier
    ) {
        PlanetsList(
            planetLocals = planetLocals,
            onClick = onClick,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding()
            ),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        )
        PlanetsDetail(
            selectedPlanetLocal = selectedPlanetLocal,
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
                planetLocals = LocalPlanetsDataProvider.getPlanetsData(),
                selectedPlanetLocal = LocalPlanetsDataProvider.getPlanetsData().getOrElse(0){
                    LocalPlanetsDataProvider.defaultPlanet
                },
                onClick = {},
                onBackPressed = {})
        }
    }
}