package com.tryden.planets.ui.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tryden.planets.R
import com.tryden.planets.data.remote.dto.PlanetDto

@Composable
fun PlanetsList(
    planets: List<PlanetDto>,
    onClick: (PlanetDto) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(
            top = dimensionResource(R.dimen.padding_medium),
            bottom = dimensionResource(R.dimen.padding_medium)
        ),
    ) {
        items(planets, key = { planet -> planet.id}) { planet ->
            PlanetsListItem(
                planet = planet,
                onItemClick = onClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetsListItem(
    planet: PlanetDto,
    onItemClick: (PlanetDto) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        onClick = { onItemClick(planet) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ){
                PlanetsListImageItem(
                    planet = planet,
                    modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
                )
            }
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = planet.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
                Text(
                    text = planet.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
        }
    }
}

@Composable
private fun PlanetsListImageItem(planet: PlanetDto, modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
//        Image(
//            painter = painterResource(id = planetLocal.imageResourceId),
//            contentDescription = null,
//            alignment = Alignment.Center,
//            contentScale = ContentScale.FillWidth
//        )
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(planet.imgSrc)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = planet.description,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


//@Preview
//@Composable
//fun PlanetsListItemPreview() {
//    PlanetsTheme {
//        PlanetsListItem(
//            planet = Planet (
//                // todo
//            ),
//            onItemClick = {}
//        )
//    }
//}

//@Preview
//@Composable
//fun PlanetsListPreview() {
//    PlanetsTheme {
//        Surface {
//            PlanetsList(
//                planets = LocalPlanetsDataProvider.getPlanetsData(),
//                onClick = {},
//            )
//        }
//    }
//}