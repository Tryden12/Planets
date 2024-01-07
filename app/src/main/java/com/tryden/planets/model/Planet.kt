package com.tryden.planets.model

data class Planet(
    val basicDetails: BasicDetails,
    val description: String,
    val id: Int,
    val imgSrc: ImgSrc,
    val name: String,
    val planetOrder: Int,
    val source: String,
    val wikiLink: String
)