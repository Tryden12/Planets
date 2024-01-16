package com.tryden.planets.ui.screens.detail

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose.PlanetsTheme
import com.tryden.planets.R
import com.tryden.planets.domain.model.Planet
import com.tryden.planets.utils.PlanetsContentType


@Composable
fun PlanetsDetailScreen(
    planet: Planet,
    contentType: PlanetsContentType,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
    }
    val layoutDirection = LocalLayoutDirection.current
    val horizontalPadding = dimensionResource(id = R.dimen.padding_detail_content_horizontal)
    val verticalPadding = dimensionResource(id = R.dimen.padding_detail_content_vertical)
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp


    // Parent column
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.black))
            .padding(
                top = contentPadding.calculateTopPadding(),
                start = contentPadding.calculateStartPadding(layoutDirection),
                end = contentPadding.calculateEndPadding(layoutDirection),
                bottom = contentPadding.calculateBottomPadding(),
            )
    ) {
        // Planet Image
        Column(
            Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = horizontalPadding,
                    vertical = verticalPadding
                )
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(planet.imgUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Inside,
                contentDescription = planet.description,
                alignment = Alignment.Center,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                modifier = Modifier
                    .height(screenHeight / 2)
                    .fillMaxWidth()
            )
        }
        // Planet info
        Column(
            Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = horizontalPadding,
                    vertical = verticalPadding
                )
        ) {
            // Planet name
            Text(
                text = planet.name,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
            )
            // Planet description
            Text(
                text = planet.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Left,
                modifier = Modifier

            )
        }
        Log.d("PlanetsDetailScreen", "ContentType: ${contentType.name}")
        if (contentType == PlanetsContentType.ListAndDetail) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .padding(horizontal = horizontalPadding,)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                ) {
                    // Planet mass
                    Text(
                        text = stringResource(id = R.string.mass),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier

                    )
                    Text(
                        text = planet.mass,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(top = 5.dp, end = 24.dp)
                    )
                    // Planet volume
                    Text(
                        text = stringResource(id = R.string.volume),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier

                    )
                    Text(
                        text = planet.volume,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        } else {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding,)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = verticalPadding)
                ) {
                    // Planet mass
                    Text(
                        text = stringResource(id = R.string.mass),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(.28f)

                    )
                    Text(
                        text = planet.mass,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.weight(.72f)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Planet volume
                    Text(
                        text = stringResource(id = R.string.volume),
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(.28f)

                    )
                    Text(
                        text = planet.volume,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier.weight(.72f)

                    )
                }

            }
        }

        Spacer(modifier = Modifier.height(75.dp).fillMaxSize())
    }
}

@Preview
@Composable
fun PlanetsDetailPreview() {
    PlanetsTheme {
        PlanetsDetailScreen(
            planet = Planet(),
            onBackPressed = { },
            contentType = PlanetsContentType.ListAndDetail,
            contentPadding = PaddingValues(),
            modifier = Modifier
        )
    }
}