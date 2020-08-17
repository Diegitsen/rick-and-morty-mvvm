package com.diegitsen.rickandmorty.data.datasource

import android.os.Handler
import com.diegitsen.rickandmorty.data.model.Episode

class EpisodeRemoteDatasource {
    fun getEpisodes(onEpisodeRemoteReadyCallback: OnEpisodeRemoteReadyCallback){
        var arrayList = ArrayList<Episode>()
        arrayList.add(Episode(1, "Ataque zombie", "23 Jun 20", "001"))
        arrayList.add(Episode(2, "Pickle Rick!!", "30 Jun 20", "002"))
        arrayList.add(Episode(3, "Vamos a Marte", "27 Jul 20", "003"))

        Handler().postDelayed({ onEpisodeRemoteReadyCallback.onRemoteDataReady(arrayList) }, 2000)
    }
}

interface OnEpisodeRemoteReadyCallback{
    fun onRemoteDataReady(data: ArrayList<Episode>)
}
