package com.tryden.planets.ui.screens.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose.PlanetsTheme
import com.tryden.planets.R
import com.tryden.planets.domain.model.Planet



@Composable
fun PlanetsDetail(
    planet: Planet,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
    }
    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current
    Box(
       modifier = modifier
           .verticalScroll(state = scrollState)
           .padding(top = contentPadding.calculateTopPadding())
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = contentPadding.calculateTopPadding(),
                    start = contentPadding.calculateStartPadding(layoutDirection),
                    end = contentPadding.calculateEndPadding(layoutDirection)
                )
        ) {
            // Top Image
            PlanetDetailImageBox(planet)

            // Bottom planet info
            PlanetDetailInfo(planet)
        }
    }
}

@Composable
fun PlanetDetailImageBox(
    planet: Planet,
    modifier: Modifier = Modifier
) {
    Box {
        Box(
            Modifier.background(color = colorResource(id = R.color.black))
        ){
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(planet.imgUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillWidth,
                contentDescription = planet.description,
                alignment = Alignment.TopCenter,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                modifier = Modifier.fillMaxWidth()
            )

        }
        Column(
            Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                        0f,
                        400f
                    )
                )
        ) {
            Text(
                text = planet.name,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.inverseOnSurface,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun PlanetDetailInfo(
    planet: Planet,
    modifier: Modifier = Modifier
) {
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(50.dp)
//            .background(MaterialTheme.colorScheme.onSurfaceVariant, shape = RectangleShape),
//        horizontalArrangement = Arrangement.Start,
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Column(modifier = modifier){
//            Text(
//                text = stringResource(id = R.string.mass),
//                style = MaterialTheme.typography.bodyLarge,
//                color = MaterialTheme.colorScheme.onPrimary,
//                modifier = Modifier.padding(
//                    vertical = dimensionResource(id = R.dimen.padding_detail_content_vertical),
//                    horizontal = dimensionResource(id = R.dimen.padding_detail_content_horizontal)
//                )
//            )
//            Text(
//                text = planet.mass,
//                style = MaterialTheme.typography.bodyMedium,
//                color = MaterialTheme.colorScheme.onPrimary,
//                modifier = Modifier.padding(
//                    vertical = dimensionResource(id = R.dimen.padding_detail_content_vertical),
//                    horizontal = dimensionResource(id = R.dimen.padding_detail_content_horizontal)
//                )
//            )
//        }
//        Column(
//            modifier = modifier
//        ){
//            Text(
//                text = stringResource(id = R.string.volume),
//                style = MaterialTheme.typography.bodyLarge,
//                color = MaterialTheme.colorScheme.onPrimary,
//                modifier = Modifier.padding(
//                    vertical = dimensionResource(id = R.dimen.padding_detail_content_vertical),
//                    horizontal = dimensionResource(id = R.dimen.padding_detail_content_horizontal)
//                )
//            )
//            Text(
//                text = planet.volume,
//                style = MaterialTheme.typography.bodyMedium,
//                color = MaterialTheme.colorScheme.onPrimary,
//                modifier = Modifier.padding(
//                    vertical = dimensionResource(id = R.dimen.padding_detail_content_vertical),
//                    horizontal = dimensionResource(id = R.dimen.padding_detail_content_horizontal)
//                )
//            )
//        }
//    }
    Text(
        text = planet.description,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(
            vertical = dimensionResource(id = R.dimen.padding_detail_content_vertical),
            horizontal = dimensionResource(id = R.dimen.padding_detail_content_horizontal)
        )
    )
}

@Preview
@Composable
fun PlanetsDetailPreview() {
    PlanetsTheme {
        PlanetsDetail(
            planet = Planet(),
            onBackPressed = { },
            contentPadding = PaddingValues(),
            modifier = Modifier
        )
    }
}