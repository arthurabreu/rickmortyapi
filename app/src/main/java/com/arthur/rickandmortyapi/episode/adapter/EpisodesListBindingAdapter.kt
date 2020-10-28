package com.arthur.rickandmortyapi.episode.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthur.rickandmortyapi.data.local.Result

@BindingAdapter("episodesList")
fun RecyclerView.bindItems(items: List<Result>?) {

    items?.let { val adapter = adapter as EpisodeAdapter
        adapter.update(items) }
}