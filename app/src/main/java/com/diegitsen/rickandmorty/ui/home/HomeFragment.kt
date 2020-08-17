package com.diegitsen.rickandmorty.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegitsen.rickandmorty.R
import com.diegitsen.rickandmorty.data.model.Character
import com.diegitsen.rickandmorty.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val characterAdapter = CharacterAdapter(arrayListOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.rvHomeCharacters.layoutManager = LinearLayoutManager(context)
        binding.rvHomeCharacters.adapter = characterAdapter
        viewModel.characters.observe(viewLifecycleOwner, Observer<ArrayList<Character>> {it?.let{ characterAdapter.replaceData(it) }})
    }
}


