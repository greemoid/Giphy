package com.greemoid.giphy.presentation.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.greemoid.giphy.databinding.FragmentGifBinding


class GifFragment : Fragment() {

    private lateinit var binding: FragmentGifBinding
    val args: GifFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentGifBinding.inflate(inflater, container, false)
        return binding.root
    }



   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_gifFragment_to_gridOfGifsFragment)
        return true
    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gif = args.giphy
        Glide.with(this)
            .asGif()
            .load(gif.url)
            .into(binding.imageViewGif)
    }
}