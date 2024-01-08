package com.tryden.planets.domain.model

data class Planet(
    val id: Int,
    val name: String,
    val description: String,
    val imgUrl: String,
    val imgDescription: String,
    val wikiLink: String,
    val planetOrder: Int,
    val mass: String,
    val volume: String
)
