package com.tryden.planets.data

import com.tryden.planets.data.remote.RemoteDataSource
import com.tryden.planets.domain.Planet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * This is the Repository class which fetches the data from the webservice.
 */
class DataRepository @Inject
constructor(
    private val remoteDataSource: RemoteDataSource
) : DataSource {
    override fun getAllPlanets(): Flow<List<Planet>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlanet(id: Int): Planet {
        TODO("Not yet implemented")
    }

}
