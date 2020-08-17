package com.diegitsen.rickandmorty.ui.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegitsen.rickandmorty.data.model.Character
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.databinding.AdapterCharacterBinding
import com.diegitsen.rickandmorty.databinding.AdapterEpisodeBinding
import com.diegitsen.rickandmorty.ui.home.CharacterAdapter

class EpisodeAdapter(private var items: ArrayList<Episode>) :
    RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = AdapterEpisodeBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun replaceData(arrayList: ArrayList<Episode>) {
        items = arrayList
        notifyDataSetChanged()
    }


    class ViewHolder(private var binding: AdapterEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: Episode) {
            binding.episode = episode
            binding.executePendingBindings()
        }
    }


}
