package com.tryden.planets.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlanetResponse(
    val basicDetails: BasicDetails,
    val description: String,
    val id: Int,
    val imgSrc: ImgSrc,
    val name: String,
    val planetOrder: Int,
    val source: String,
    val wikiLink: String
) {

    @Serializable
    data class BasicDetails(
        val mass: String,
        val volume: String
    )
    @Serializable
    data class ImgSrc(
        val img: String,
        val imgDescription: String
    )
}