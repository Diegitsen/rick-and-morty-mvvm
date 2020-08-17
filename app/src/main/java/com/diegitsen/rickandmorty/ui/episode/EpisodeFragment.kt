package com.diegitsen.rickandmorty.ui.episode

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
import com.diegitsen.rickandmorty.databinding.FragmentEpisodeBinding

class EpisodeFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeBinding
    private val episodeAdapter = EpisodeAdapter(arrayListOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_episode, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(EpisodeViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.rvEpisode.layoutManager = LinearLayoutManager(context)
        binding.rvEpisode.adapter = episodeAdapter
        viewModel.episodes.observe(viewLifecycleOwner, Observer<ArrayList<Episode>>{it?.let{ episodeAdapter.replaceData(it) }})
    }
}
