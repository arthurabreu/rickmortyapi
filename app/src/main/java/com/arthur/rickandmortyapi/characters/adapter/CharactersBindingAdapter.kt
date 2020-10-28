package com.arthur.rickandmortyapi.characters.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arthur.rickandmortyapi.data.local.Character

@BindingAdapter("charactersList")
fun RecyclerView.bindItems(items: List<Character>?) {

    items?.let { val adapter = adapter as CharactersAdapter
        adapter.update(items) }
}