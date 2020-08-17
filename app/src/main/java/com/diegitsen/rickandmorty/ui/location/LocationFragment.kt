package com.diegitsen.rickandmorty.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegitsen.rickandmorty.R
import com.diegitsen.rickandmorty.data.model.Episode
import com.diegitsen.rickandmorty.data.model.Location
import com.diegitsen.rickandmorty.databinding.FragmentEpisodeBinding
import com.diegitsen.rickandmorty.databinding.FragmentLocationBinding
import com.diegitsen.rickandmorty.ui.episode.EpisodeAdapter
import com.diegitsen.rickandmorty.ui.episode.EpisodeViewModel

class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private val locationAdapter = LocationAdapter(arrayListOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(LocationViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.rvLocation.layoutManager = LinearLayoutManager(context)
        binding.rvLocation.adapter = locationAdapter
        viewModel.loadLocations()
        viewModel.locations.observe(viewLifecycleOwner, Observer<ArrayList<Location>>{it?.let{ locationAdapter.replaceData(it) }})
    }
}