package com.diegitsen.rickandmorty.ui.episode

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.data.repository.EpisodeRepository
import com.diegitsen.rickandmorty.data.repository.OnEpisodeRepositoryReadyCallback
import java.util.*
import kotlin.collections.ArrayList

class EpisodeViewModel : ViewModel() {
    var episodeRepository = EpisodeRepository()
    val isLoading = ObservableField(false)
    var episodes = MutableLiveData<ArrayList<Episode>>()
    fun loadEpisodes(){
        isLoading.set(true)
        episodeRepository.getEpisodes(object : OnEpisodeRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Episode>) {
                isLoading.set(false)
                episodes.value = data
            }

        })
    }
}
