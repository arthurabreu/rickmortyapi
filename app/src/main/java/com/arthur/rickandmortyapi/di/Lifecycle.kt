package com.arthur.rickandmortyapi.di

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

fun LifecycleOwner.observeLifecycleIn(observer: LifecycleObserver) =
        lifecycle.addObserver(observer)