package com.diegitsen.rickandmorty.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegitsen.rickandmorty.data.model.Character
import com.diegitsen.rickandmorty.data.repository.CharacterRepository
import com.diegitsen.rickandmorty.data.repository.OnRepositoryReadyCallback

class HomeViewModel : ViewModel() {

    var characterRepository = CharacterRepository()
    val isLoading = ObservableField(false)
    var characters = MutableLiveData<ArrayList<Character>>()

    fun loadCharacters(){
        isLoading.set(true)
        characterRepository.getCharacters(object: OnRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Character>) {
                isLoading.set(false)
                characters.value = data
            }

        })
    }
}

