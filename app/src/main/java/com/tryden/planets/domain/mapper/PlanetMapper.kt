package com.tryden.planets.domain.mapper

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.domain.model.Planet

object PlanetMapper {
    fun buildFrom(planet: PlanetDto): Planet {
        return Planet(
            id = planet.id,
            name = planet.name,
            description = planet.description,
            imgUrl = planet.imgSrc.img,
            imgDescription = planet.imgSrc.imgDescription,
            wikiLink = planet.wikiLink,
            planetOrder = planet.planetOrder,
            mass = planet.basicDetails.mass,
            volume = planet.basicDetails.mass
        )
    }
}