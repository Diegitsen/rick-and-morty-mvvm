package com.diegitsen.rickandmorty.data.datasource

import android.os.Handler
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.data.model.Location

class LocationRemoteDatasource {
    fun getLocations(onLocationRemoteReadyCallback: OnLocationRemoteReadyCallback){
        var arrayList = ArrayList<Location>()
        arrayList.add(Location(1, "Earth", "Planet", "100"))
        arrayList.add(Location(2, "Mars", "Planet", "100"))
        arrayList.add(Location(3, "Venus", "Planet", "100"))

        Handler().postDelayed({ onLocationRemoteReadyCallback.onRemoteDataReady(arrayList) }, 2000)
    }
}

interface OnLocationRemoteReadyCallback{
    fun onRemoteDataReady(data: ArrayList<Location>)
}