package com.example.movietopia.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietopia.R
import com.example.movietopia.databinding.ItemMovieVerticalBinding
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.IMAGE_URL
import com.example.movietopia.model.utils.response.DataMovieResponse

class MovieAdapter(
    var data: List<DataMovieResponse>,
    private val itemClickCallback : onItemClickCallback
): RecyclerView.Adapter<MovieAdapter.ItemHolder>()
{
    private lateinit var binding: ItemMovieVerticalBinding

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: DataMovieResponse){
            binding = ItemMovieVerticalBinding.bind(itemView)
            binding.tvMovieName.text = item.title
            binding.tvMovieRatenYear.text = "${item.vote_average} - ${item.release_date}"
            binding.tvMovieDescription.text = item.overview

            val uriPoster = IMAGE_URL+item.poster_path

            Glide.with(itemView.context)
                .load(uriPoster)
                .into(binding.ivImgMovie)

            binding.root.setOnClickListener {
                itemClickCallback.onSelectedItem(item)
            }
        }
    }

    interface onItemClickCallback{
        fun onSelectedItem(item: DataMovieResponse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_vertical, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size
}