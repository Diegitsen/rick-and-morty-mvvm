package com.diegitsen.rickandmorty.data.repository

import com.diegitsen.rickandmorty.data.datasource.EpisodeRemoteDatasource
import com.diegitsen.rickandmorty.data.datasource.LocationRemoteDatasource
import com.diegitsen.rickandmorty.data.datasource.OnEpisodeRemoteReadyCallback
import com.diegitsen.rickandmorty.data.model.Episode

class EpisodeRepository {

    val remoteDataSource = EpisodeRemoteDatasource()
    fun getEpisodes(onEpisodeRepositoryReadyCallback: OnEpisodeRepositoryReadyCallback){
        remoteDataSource.getEpisodes(object : OnEpisodeRemoteReadyCallback{
            override fun onRemoteDataReady(data: ArrayList<Episode>) {
                onEpisodeRepositoryReadyCallback.onDataReady(data)
            }

        })

    }

}

interface OnEpisodeRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Episode>)
}
