package com.arthur.rickandmortyapi.episode

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.arthur.rickandmortyapi.episode.model.ViewModelTest
import com.arthur.rickandmortyapi.episode.model.getEpisodes
import com.arthur.rickandmortyapi.episode.model.getResult
import com.arthur.rickandmortyapi.episode.viewmodel.EpisodeViewModel
import com.arthur.rickandmortyapi.network.CustomScheduler
import com.arthur.rickandmortyapi.network.NetworkInterface
import com.arthur.rickandmortyapi.utils.ErrorHandler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class EpisodeViewModelTest : ViewModelTest() {

    var networkClient: NetworkInterface = mock {
        on { getEpisodes() } doReturn Single.just(getEpisodes())
    }
    var errorHandler: ErrorHandler = mock()
    var testSchedulers: CustomScheduler = mock {
        on { io() } doReturn Schedulers.trampoline()
        on { ui() } doReturn Schedulers.trampoline()
    }
    val viewModel by lazy { EpisodeViewModel(networkClient, testSchedulers, errorHandler) }

    @Test
    fun `should return episodes when episodesList value changes`() {
        viewModel.onCreate()
        viewModel.episodes.value shouldBeEqualTo listOf(getResult())
    }
}