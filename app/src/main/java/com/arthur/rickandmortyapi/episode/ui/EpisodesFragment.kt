package com.arthur.rickandmortyapi.episode.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arthur.rickandmortyapi.R
import com.arthur.rickandmortyapi.databinding.EpisodesFragmentBinding
import com.arthur.rickandmortyapi.di.observeLifecycleIn
import com.arthur.rickandmortyapi.episode.adapter.EpisodeAdapter
import com.arthur.rickandmortyapi.episode.viewmodel.EpisodeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class EpisodesFragment : Fragment() {

    private val episodeViewModel: EpisodeViewModel by viewModel()
    private lateinit var binding: EpisodesFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<EpisodesFragmentBinding>(
                    inflater,
                    R.layout.episodes_fragment,
                    container,
                    false
            ).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(episodeViewModel)
        binding.run {
            this.viewModel = episodeViewModel
            initRecycler(binding)
            lifecycleOwner = this@EpisodesFragment
        }
    }

    private fun initRecycler(
            activityMainBinding: EpisodesFragmentBinding
    ) {
        val layoutManager = LinearLayoutManager(context)

        val recyclerEpisodes = activityMainBinding.episodesRecycler
        recyclerEpisodes.layoutManager = layoutManager
        recyclerEpisodes.hasFixedSize()
        recyclerEpisodes.adapter = EpisodeAdapter()
        recyclerEpisodes.addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                        context,
                        layoutManager.orientation
                )
        )
    }
}