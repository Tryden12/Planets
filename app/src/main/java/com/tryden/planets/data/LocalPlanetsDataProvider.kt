package com.tryden.planets.data

import com.tryden.planets.R
import com.tryden.planets.model.Planet

/**
 * Using local Planets data for simplicity to showcase UI fundamentals.
 */
object LocalPlanetsDataProvider {
    val defaultPlanet = getPlanetsData()[0]

    fun getPlanetsData(): List<Planet> {
        return listOf(
            Planet(
                id = 1,
                titleResourceId = R.string.mercury,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.mercury,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 2,
                titleResourceId = R.string.venus,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.venus,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 3,
                titleResourceId = R.string.earth,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.earth,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 4,
                titleResourceId = R.string.mars,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.mars,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 5,
                titleResourceId = R.string.jupiter,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.jupiter,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 6,
                titleResourceId = R.string.saturn,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.saturn,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 7,
                titleResourceId = R.string.uranus,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.uranus,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 8,
                titleResourceId = R.string.neptune,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.neptune,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
            ),
            Planet(
                id = 9,
                titleResourceId = R.string.dwarf_planets,
                subtitleResourceId = R.string.planets_list_subtitle,
                imageResourceId = R.drawable.pluto,
                planetsImageBanner = R.drawable.space_banner,
                planetDetails = R.string.planets_detail_text
        )
        )
    }
}