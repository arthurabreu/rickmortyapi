package com.arthur.rickandmortyapi.locations.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthur.rickandmortyapi.data.local.Location

@BindingAdapter("locationsList")
fun RecyclerView.bindItems(items: List<Location>?) {

    items?.let { val adapter = adapter as LocationsAdapter
        adapter.update(items) }
}