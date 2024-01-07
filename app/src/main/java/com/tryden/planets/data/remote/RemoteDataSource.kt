package com.tryden.planets.data.remote

import android.util.Log
import com.tryden.planets.data.Resource
import com.tryden.planets.data.remote.dto.PlanetResponse
import com.tryden.planets.domain.Planet
import com.tryden.planets.network.PlanetsApiService
import javax.inject.Inject

class RemoteDataSource @Inject
constructor(private val api: PlanetsApiService): RemoteSource {
    override suspend fun getAllPlanets(): Resource<List<PlanetResponse>> {
        try {
            val planetsList = mutableListOf<Planet>()
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

    override suspend fun getPlanet(id: Int): Resource<PlanetResponse> {
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