package com.arthur.rickandmortyapi.network

import com.arthur.rickandmortyapi.data.local.Characters
import com.arthur.rickandmortyapi.data.local.Episodes
import com.arthur.rickandmortyapi.data.local.Locations
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkInterface {

    @GET("episode/")
    fun getEpisodes(): Single<Episodes>

    @GET("location/")
    fun getLocations(): Single<Locations>

    @GET("character/")
    fun getCharacters(): Single<Characters>
}