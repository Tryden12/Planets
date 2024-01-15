package com.tryden.planets.di

import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.data.repository.DataRepository
import com.tryden.planets.data.repository.DataRepositoryImpl
import com.tryden.planets.domain.mapper.Mapper
import com.tryden.planets.domain.mapper.PlanetMapper
import com.tryden.planets.domain.model.Planet
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    @Singleton
    fun bindDataRepository(dataRepository: DataRepositoryImpl): DataRepository


    @Binds
    @Singleton
    fun bindPlanetMapper(planetMapper: PlanetMapper): Mapper<Planet, PlanetDto>
}