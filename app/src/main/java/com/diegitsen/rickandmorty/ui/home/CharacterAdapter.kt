package com.diegitsen.rickandmorty.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.diegitsen.rickandmorty.data.model.Character
import com.diegitsen.rickandmorty.databinding.AdapterCharacterBinding
import com.diegitsen.rickandmorty.databinding.FragmentHomeBinding.inflate

class CharacterAdapter(private var items: ArrayList<Character>):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = AdapterCharacterBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun replaceData(arrayList: ArrayList<Character>) {
        items = arrayList
        notifyDataSetChanged()
    }


    class ViewHolder(private var binding: AdapterCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.character = character
            binding.executePendingBindings()
        }
    }



}
