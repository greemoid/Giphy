package com.greemoid.giphy.presentation.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greemoid.giphy.R
import com.greemoid.giphy.databinding.GifItemLayoutBinding
import com.greemoid.giphy.domain.models.Giphy

class GifsAdapter : RecyclerView.Adapter<GifsAdapter.GifsViewHolder>() {

    var trendingGifs = emptyList<Giphy>()

    inner class GifsViewHolder(val binding: GifItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun displayGif(item: Giphy) {
            Glide.with(itemView.context)
                .asGif()
                .load(item.url_medium)
                .into(binding.imageViewGif)
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Giphy>() {
        override fun areItemsTheSame(oldItem: Giphy, newItem: Giphy): Boolean {
            return oldItem.url_medium == newItem.url_medium
        }

        override fun areContentsTheSame(oldItem: Giphy, newItem: Giphy): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        val binding =
            GifItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.displayGif(item)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(item) }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size


    fun setOnItemClickListener(listener: (Giphy) -> Unit) {
        onItemClickListener = listener
    }

}

private var onItemClickListener: ((Giphy) -> Unit)? = null
