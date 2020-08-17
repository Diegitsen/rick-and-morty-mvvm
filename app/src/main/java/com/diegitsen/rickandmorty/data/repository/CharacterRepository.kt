package com.diegitsen.rickandmorty.data.repository

import com.diegitsen.rickandmorty.data.datasource.CharacterRemoteDatasource
import com.diegitsen.rickandmorty.data.datasource.OnCharacterRemoteReadyCallback
import com.diegitsen.rickandmorty.data.model.Character

class CharacterRepository {

    private val remoteDataSource = CharacterRemoteDatasource()

    fun getCharacters(onRepositoryReadyCallback: OnRepositoryReadyCallback){

        remoteDataSource.getCharacters(object : OnCharacterRemoteReadyCallback{
            override fun onRemoteDataReady(data: ArrayList<Character>) {
                onRepositoryReadyCallback.onDataReady(data)
            }

        })
    }
}

interface OnRepositoryReadyCallback {
    fun onDataReady(data: ArrayList<Character>)
}