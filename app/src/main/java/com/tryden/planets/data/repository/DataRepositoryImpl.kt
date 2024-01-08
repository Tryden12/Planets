package com.tryden.planets.data.repository

import com.tryden.planets.data.remote.RemoteSource
import com.tryden.planets.domain.model.Planet
import com.tryden.planets.domain.mapper.PlanetMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * This is the Repository class which fetches the data from the webservice and maps DTO models
 * to UI models using a mapper object: PlanetMapper.
 */
class DataRepositoryImpl @Inject
constructor(
    private val remoteDataSource: RemoteSource,
    private val planetMapper: PlanetMapper
) : DataRepository {

    /**
     * We use flow on Dispatchers.IO thread to fetch the planets list data.
     * We then map from DTO model to a UI model using PlanetMapper object.
     */
    override fun getAllPlanets(): Flow<List<Planet>> {
        return flow {
            remoteDataSource.getAllPlanets().data?.let { list ->
                emit(list.map { planetDto ->
                    planetMapper.buildFrom(planetDto)
                })
            }
        }.flowOn(Dispatchers.IO)
    }

    /**
     * We fetch the planet data. We then map from DTO model to a UI model using PlanetMapper object.
     */
    override suspend fun getPlanet(id: Int): Planet? {
        return remoteDataSource.getPlanet(id).data?.let { planetDto ->
            planetMapper.buildFrom(planetDto)
        }
    }

}
