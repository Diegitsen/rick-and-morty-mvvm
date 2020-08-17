package com.diegitsen.rickandmorty.ui.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.data.model.Location
import com.diegitsen.rickandmorty.databinding.AdapterEpisodeBinding
import com.diegitsen.rickandmorty.databinding.AdapterLocationBinding
import com.diegitsen.rickandmorty.ui.episode.EpisodeAdapter

class LocationAdapter(private var items: ArrayList<Location>) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = AdapterLocationBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun replaceData(arrayList: ArrayList<Location>) {
        items = arrayList
        notifyDataSetChanged()
    }


    class ViewHolder(private var binding: AdapterLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: Location) {
            binding.location = location
            binding.executePendingBindings()
        }
    }


}