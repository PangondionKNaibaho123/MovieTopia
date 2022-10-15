package com.example.movietopia.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietopia.R
import com.example.movietopia.databinding.ItemMovieVerticalBinding
import com.example.movietopia.model.utils.DummyMovie

class DummyMovieVerticalAdapter(
    var data: List<DummyMovie>,
    private val itemClickCallback: DummyMovieVerticalAdapter.onItemClickCallback
): RecyclerView.Adapter<DummyMovieVerticalAdapter.ItemHolder>()
{
    private lateinit var binding: ItemMovieVerticalBinding

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: DummyMovie){
            binding = ItemMovieVerticalBinding.bind(itemView)
            binding.tvMovieName.text = item.movieName
            binding.tvMovieRatenYear.text = "${item.movieRate} - ${item.movieYear}"
            binding.root.setOnClickListener {
                itemClickCallback.onSelectedItem()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_vertical, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    interface onItemClickCallback{
        fun onSelectedItem()
    }
}