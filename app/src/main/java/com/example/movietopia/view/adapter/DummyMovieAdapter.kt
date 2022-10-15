package com.example.movietopia.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietopia.R
import com.example.movietopia.databinding.ItemMovieHorizontalBinding
import com.example.movietopia.model.utils.DummyMovie

class DummyMovieAdapter(
    var data:List<DummyMovie>,
    private val itemClickCallback: onItemClickCallback
): RecyclerView.Adapter<DummyMovieAdapter.ItemHolder>()
{
    private lateinit var binding: ItemMovieHorizontalBinding
    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: DummyMovie){
            binding = ItemMovieHorizontalBinding.bind(itemView)

            binding.tvMovieName.text = item.movieName
            binding.tvRatenYear.text = "${item.movieRate} - ${item.movieYear}"
            binding.root.setOnClickListener {
                itemClickCallback.onSelectedItem()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_horizontal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    interface onItemClickCallback{
        fun onSelectedItem()
    }
}