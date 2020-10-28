package com.arthur.rickandmortyapi.locations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arthur.rickandmortyapi.R
import com.arthur.rickandmortyapi.data.local.Location

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder>() {

    private var locations : List<Location> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_location, parent, false)
        return LocationsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.bind(locations[position])
    }

    fun update(items: List<Location>) {
        locations = items
        notifyDataSetChanged()
    }

    class LocationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title: TextView? = null

        init {
            title = itemView.findViewById(R.id.location_name)
        }

        fun bind(location: Location) {
            title?.text = location.name
        }
    }
}