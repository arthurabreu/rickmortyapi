package com.arthur.rickandmortyapi.di

import com.arthur.rickandmortyapi.characters.ui.CharactersFragment
import com.arthur.rickandmortyapi.characters.viewmodel.CharactersViewModel
import com.arthur.rickandmortyapi.episode.ui.EpisodesFragment
import com.arthur.rickandmortyapi.episode.viewmodel.EpisodeViewModel
import com.arthur.rickandmortyapi.locations.ui.LocationsFragment
import com.arthur.rickandmortyapi.locations.viewmodel.LocationsViewModel
import com.arthur.rickandmortyapi.network.CustomScheduler
import com.arthur.rickandmortyapi.network.NetworkClient
import com.arthur.rickandmortyapi.utils.ErrorHandler
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { CustomScheduler() }
    factory { NetworkClient().networkResponse }
    single { ErrorHandler(get()) }

    single { EpisodesFragment() }
    single { CharactersFragment() }
    single { LocationsFragment() }

    viewModel { EpisodeViewModel(get(), get(), get()) }
    viewModel { CharactersViewModel(get(), get(), get()) }
    viewModel { LocationsViewModel(get(), get(), get()) }
}
