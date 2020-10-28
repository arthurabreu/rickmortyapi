package com.arthur.rickandmortyapi.network

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CustomScheduler {

    fun io() = Schedulers.io()

    fun ui() = AndroidSchedulers.mainThread()
}