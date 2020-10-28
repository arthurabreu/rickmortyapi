package com.arthur.rickandmortyapi.episode.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arthur.rickandmortyapi.R
import com.arthur.rickandmortyapi.data.local.Result

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private var episodes : List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_episode, parent, false)
        return EpisodeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(episodes[position])
    }

    fun update(items: List<Result>) {
        episodes = items
        notifyDataSetChanged()
    }

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title: TextView? = null

        init {
            title = itemView.findViewById(R.id.episode_name)
        }

        fun bind(episode: Result) {
            title?.text = episode.name
        }
    }
}