package com.tryden.planets.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Planet(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val planetsImageBanner: Int,
    @StringRes val planetDetails: Int
)
