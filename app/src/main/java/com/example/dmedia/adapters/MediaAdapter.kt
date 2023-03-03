package com.example.dmedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dmedia.databinding.LayoutMediaitemBinding
import com.example.dmedia.models.Content
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaAdapter @Inject constructor() : PagingDataAdapter<Content, MediaAdapter.MediaViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<Content>() {
        override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        return MediaViewHolder(
            LayoutMediaitemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) {
            holder.bind(item)
        }
    }

    inner class MediaViewHolder constructor(private val binding: LayoutMediaitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mediaItem: Content) {
            binding.mediaItem = mediaItem

            binding.executePendingBindings()
        }
    }


}