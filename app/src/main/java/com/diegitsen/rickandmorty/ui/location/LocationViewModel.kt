package com.diegitsen.rickandmorty.ui.location

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.data.model.Location
import com.diegitsen.rickandmorty.data.repository.EpisodeRepository
import com.diegitsen.rickandmorty.data.repository.LocationRepository
import com.diegitsen.rickandmorty.data.repository.OnEpisodeRepositoryReadyCallback
import com.diegitsen.rickandmorty.data.repository.OnLocationRepositoryReadyCallback

class LocationViewModel : ViewModel() {

    var locationRepository = LocationRepository()
    val isLoading = ObservableField(false)
    var locations = MutableLiveData<ArrayList<Location>>()

    fun loadLocations(){
        isLoading.set(true)
        locationRepository.getLocations(object : OnLocationRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Location>) {
                isLoading.set(false)
                locations.value = data
            }
        })
    }
}