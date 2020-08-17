package com.diegitsen.rickandmorty.data.repository

import com.diegitsen.rickandmorty.data.datasource.EpisodeRemoteDatasource
import com.diegitsen.rickandmorty.data.datasource.LocationRemoteDatasource
import com.diegitsen.rickandmorty.data.datasource.OnLocationRemoteReadyCallback
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.data.model.Location

class LocationRepository {
    private val remoteDataSource = LocationRemoteDatasource()
    fun getLocations(onLocationRepositoryReadyCallback: OnLocationRepositoryReadyCallback){
        remoteDataSource.getLocations(object : OnLocationRemoteReadyCallback{
            override fun onRemoteDataReady(data: ArrayList<Location>) {
                onLocationRepositoryReadyCallback.onDataReady(data)
            }
        })
    }
}

interface OnLocationRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Location>)
}