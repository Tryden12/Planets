package com.tryden.planets.data.remote

import android.util.Log
import com.tryden.planets.data.Resource
import com.tryden.planets.data.remote.dto.PlanetDto
import com.tryden.planets.data.remote.service.PlanetsApiService
import javax.inject.Inject

/**
 * We fetch data from remote source: planets api.
 * We utilize the Resource class for Success, Loading, and DataError cases.
 */
class RemoteDataSource @Inject
constructor(private val api: PlanetsApiService): RemoteSource {
    override suspend fun getAllPlanets(): Resource<List<PlanetDto>> {
        try {
            val res = api.getAllPlanets()

            when (res.isSuccessful) {
                true -> {
                    res.body()?.let { planetsList ->
                        return Resource.Success(data = planetsList)
                    } ?: return Resource.DataError(errorCode = res.code())
                }
                false -> return Resource.DataError(errorCode = res.code())
            }
        } catch (e: Exception) {
            Log.e("NETWORK_API_ERROR", "List cannot load ${e.hashCode()}")
            return Resource.DataError(errorCode = e.hashCode())
        }
    }

    override suspend fun getPlanet(id: Int): Resource<PlanetDto> {
        try {
            val res = api.getPlanet(id)

            when (res.isSuccessful) {
                true -> {
                    res.body()?.let { body ->
                        return Resource.Success(data = body)
                    } ?: return Resource.DataError(errorCode = res.code())
                }
                false -> return Resource.DataError(errorCode = res.code())
            }
        } catch (e: Exception) {
            Log.e("NETWORK_API_ERROR", "List cannot load ${e.hashCode()}")
            return Resource.DataError(errorCode = e.hashCode())
        }
    }

}