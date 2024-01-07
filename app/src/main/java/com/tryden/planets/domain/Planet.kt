package com.tryden.planets.domain

import com.tryden.planets.data.remote.dto.PlanetResponse

data class Planet(
    val id: Int,
    val name: String,
    val description: String,
    val img: String,
    val imgDescription: String,
    val wikiLink: String,
    val planetOrder: Int,
    val mass: String,
    val volume: String
)
