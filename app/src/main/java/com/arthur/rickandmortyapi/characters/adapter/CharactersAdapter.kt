package com.arthur.rickandmortyapi.characters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arthur.rickandmortyapi.R
import com.arthur.rickandmortyapi.data.local.Character

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private var characters : List<Character> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_chars, parent, false)
        return CharactersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    fun update(items: List<Character>) {
        characters = items
        notifyDataSetChanged()
    }

    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title: TextView? = null

        init {
            title = itemView.findViewById(R.id.character_name)
        }

        fun bind(character: Character) {
            title?.text = character.name
        }
    }
}