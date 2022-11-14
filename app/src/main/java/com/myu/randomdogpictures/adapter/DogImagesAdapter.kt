package com.myu.randomdogpictures.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.myu.randomdogpictures.databinding.RowDogsImagesBinding

class DogImagesAdapter : RecyclerView.Adapter<DogImagesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : RowDogsImagesBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
           return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallback)
    var dogImages : List<String>
    get() = differ.currentList
    set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowDogsImagesBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentDogImage = dogImages[position]

        Glide.with(holder.binding.root)
            .load(currentDogImage)
            .transform(CircleCrop())
            .into(holder.binding.dogImage)

    }

    override fun getItemCount(): Int {
        return dogImages.size
    }
}
