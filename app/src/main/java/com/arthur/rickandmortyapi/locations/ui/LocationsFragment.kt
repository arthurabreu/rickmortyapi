package com.arthur.rickandmortyapi.locations.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arthur.rickandmortyapi.R
import com.arthur.rickandmortyapi.databinding.LocationsFragmentBinding
import com.arthur.rickandmortyapi.di.observeLifecycleIn
import com.arthur.rickandmortyapi.locations.adapter.LocationsAdapter
import com.arthur.rickandmortyapi.locations.viewmodel.LocationsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LocationsFragment : Fragment() {

    private val locationsViewModel: LocationsViewModel by viewModel()
    private lateinit var binding: LocationsFragmentBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<LocationsFragmentBinding>(
                    inflater,
                    R.layout.locations_fragment,
                    container,
                    false
            ).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(locationsViewModel)
        binding.run {
            this.viewModel = locationsViewModel
            initRecycler(binding)
            lifecycleOwner = this@LocationsFragment
        }
    }

    private fun initRecycler(
            activityMainBinding: LocationsFragmentBinding
    ) {
        val layoutManager = LinearLayoutManager(context)

        val recyclerLocations = activityMainBinding.locationsRecycler
        recyclerLocations.layoutManager = layoutManager
        recyclerLocations.hasFixedSize()
        recyclerLocations.adapter = LocationsAdapter()
        recyclerLocations.addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                        context,
                        layoutManager.orientation
                )
        )
    }
}