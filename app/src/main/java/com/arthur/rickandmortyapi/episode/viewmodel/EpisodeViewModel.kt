package com.arthur.rickandmortyapi.episode.viewmodel

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.arthur.rickandmortyapi.network.NetworkInterface
import com.arthur.rickandmortyapi.data.local.Result
import com.arthur.rickandmortyapi.network.CustomScheduler
import com.arthur.rickandmortyapi.network.RxViewModel
import com.arthur.rickandmortyapi.utils.ErrorHandler
import timber.log.Timber

class EpisodeViewModel(
        private var repo: NetworkInterface,
        private val customScheduler: CustomScheduler,
        private val errorHandler: ErrorHandler
) : RxViewModel(), LifecycleObserver {

    var episodes :  MutableLiveData<List<Result>> = MutableLiveData()
    val progressBarVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        fetchEpisodes()
    }

    private fun fetchEpisodes() {
        showProgressBar()

        launch {
            repo.getEpisodes()
                    .subscribeOn(customScheduler.io())
                    .observeOn(customScheduler.ui())
                    .subscribe({
                        Timber.d(it.toString())
                        episodes.value = it.results
                        hideProgressBar()
                    }, { error ->
                        error.message?.let {
                            Timber.e(it)
                            errorHandler.showError(it)
                        }
                    })
        }
    }

    private fun showProgressBar() {
        progressBarVisibility.value = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBarVisibility.value = View.GONE
    }
}