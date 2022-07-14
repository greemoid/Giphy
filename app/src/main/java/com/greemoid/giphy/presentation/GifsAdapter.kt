package com.greemoid.giphy.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greemoid.giphy.data.models.DownsizedLarge
import com.greemoid.giphy.databinding.GifItemLayoutBinding
import com.greemoid.giphy.domain.models.Giphy

class GifsAdapter : RecyclerView.Adapter<GifsAdapter.GifsViewHolder>() {

    var trendingGifs = emptyList<Giphy>()

    inner class GifsViewHolder(val binding: GifItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun displayGif(item: Giphy) {
            Glide.with(itemView.context)
                .asGif()
                .load(item.url)
                .into(binding.imageViewGif)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        val binding =
            GifItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {
        val item = trendingGifs[position]
        holder.displayGif(item)
    }

    override fun getItemCount(): Int = trendingGifs.size

    fun setList(list: List<Giphy>) {
        trendingGifs = list
        notifyDataSetChanged()
    }
}