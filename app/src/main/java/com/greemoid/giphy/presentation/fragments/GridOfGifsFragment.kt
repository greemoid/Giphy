package com.greemoid.giphy.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.giphy.R
import com.greemoid.giphy.databinding.FragmentGridOfGifsBinding
import com.greemoid.giphy.presentation.GifsViewModel
import com.greemoid.giphy.presentation.adapters.GifsAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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

        var job: Job? = null
        binding.etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(500L)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.getSearchGifs(editable.toString())
                    }
                }
            }
        }

        viewModel.searchGifs.observe(viewLifecycleOwner) { list ->
            adapter.differ.submitList(list)
        }


        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable("giphy", it)
            findNavController().navigate(R.id.action_gridOfGifsFragment_to_gifFragment, bundle)
        }

        viewModel.getTrendingGifs()
        viewModel.trendingGifs.observe(viewLifecycleOwner) { list ->
            adapter.differ.submitList(list)
        }
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvGifs
        adapter = GifsAdapter()
        recyclerView.adapter = adapter
    }
}