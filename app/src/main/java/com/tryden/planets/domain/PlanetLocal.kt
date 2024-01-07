package com.tryden.planets.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PlanetLocal(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val planetsImageBanner: Int,
    @StringRes val planetDetails: Int
)
