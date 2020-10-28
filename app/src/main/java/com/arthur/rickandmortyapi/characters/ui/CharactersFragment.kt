package com.arthur.rickandmortyapi.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arthur.rickandmortyapi.R
import com.arthur.rickandmortyapi.characters.adapter.CharactersAdapter
import com.arthur.rickandmortyapi.characters.viewmodel.CharactersViewModel
import com.arthur.rickandmortyapi.databinding.CharactersFragmentBinding
import com.arthur.rickandmortyapi.di.observeLifecycleIn
import org.koin.android.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private val charactersViewModel: CharactersViewModel by viewModel()
    private lateinit var binding: CharactersFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<CharactersFragmentBinding>(
                    inflater,
                    R.layout.characters_fragment,
                    container,
                    false
            ).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(charactersViewModel)
        binding.run {
            this.viewModel = charactersViewModel
            initRecycler(binding)
            lifecycleOwner = this@CharactersFragment
        }
    }

    private fun initRecycler(
            activityMainBinding: CharactersFragmentBinding
    ) {
        val layoutManager = LinearLayoutManager(context)

        val recyclerEpisodes = activityMainBinding.charactersRecycler
        recyclerEpisodes.layoutManager = layoutManager
        recyclerEpisodes.hasFixedSize()
        recyclerEpisodes.adapter = CharactersAdapter()
        recyclerEpisodes.addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                        context,
                        layoutManager.orientation
                )
        )
    }
}