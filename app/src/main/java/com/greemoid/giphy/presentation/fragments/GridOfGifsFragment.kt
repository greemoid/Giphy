package com.greemoid.giphy.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.giphy.databinding.FragmentGridOfGifsBinding
import com.greemoid.giphy.presentation.GifsAdapter
import com.greemoid.giphy.presentation.GifsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class GridOfGifsFragment : Fragment() {

    private lateinit var binding: FragmentGridOfGifsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GifsAdapter
    private val viewModel: GifsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGridOfGifsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.getTrendingGifs()
        viewModel.trendingGifs.observe(viewLifecycleOwner, {list ->
            adapter.setList(list)
        })
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvGifs
        adapter = GifsAdapter()
        recyclerView.adapter = adapter
    }
}