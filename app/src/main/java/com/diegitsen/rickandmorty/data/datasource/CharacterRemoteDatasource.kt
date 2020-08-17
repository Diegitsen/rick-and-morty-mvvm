package com.diegitsen.rickandmorty.data.datasource

import android.os.Handler
import com.diegitsen.rickandmorty.data.model.Character
import com.diegitsen.rickandmorty.service.api.ApiService
import io.reactivex.disposables.Disposable

class CharacterRemoteDatasource {

    var disposable : Disposable? = null
    val apiService by lazy { ApiService.create() }

    fun getCharacters(onCharacterRemoteReadyCallback: OnCharacterRemoteReadyCallback){

        /*var arrayList = ArrayList<Character>()
        arrayList.add(Character(1, "Rick Sanchez", "Alive", "Human", "Male", "asd"))
        arrayList.add(Character(2, "Morty", "Alive", "Human", "Male", "asd"))
        arrayList.add(Character(3, "Pickle Rick", "Dead", "Vegetable", "Male", "asd"))

        Handler().postDelayed({ onCharacterRemoteReadyCallback.onRemoteDataReady(arrayList) }, 2000)*/

    }

}

interface OnCharacterRemoteReadyCallback{
    fun onRemoteDataReady(data: ArrayList<Character>)
}

