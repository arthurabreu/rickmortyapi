package com.arthur.rickandmortyapi.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

    var networkResponse: NetworkInterface = create()

    private fun create(): NetworkInterface {

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.BASE_URL)
                .client(OkHttpClient())
                .build()
        return retrofit.create(NetworkInterface::class.java)
    }

    object AppConstants{
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}