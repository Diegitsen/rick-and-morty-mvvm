package com.diegitsen.rickandmorty.service.api

import com.diegitsen.rickandmorty.data.model.Model
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

interface ApiService {

    @GET("character")
    fun getCharacters(): Observable<Model.Result>


    companion object {
        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://rickandmortyapi.com/api/")
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}