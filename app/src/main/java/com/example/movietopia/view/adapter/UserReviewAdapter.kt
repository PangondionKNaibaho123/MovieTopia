package com.example.movietopia.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietopia.R
import com.example.movietopia.databinding.ItemUserReviewBinding
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.IMAGE_URL
import com.example.movietopia.model.utils.response.UserReview.DataUserReview

class UserReviewAdapter(var data: List<DataUserReview>): RecyclerView.Adapter<UserReviewAdapter.ItemHolder>() {
    private lateinit var binding: ItemUserReviewBinding

    inner class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: DataUserReview){
            binding = ItemUserReviewBinding.bind(itemView)
            binding.tvUserName.text = item.author
            val rating = if(item.author_detail?.rating == null) 0 else item.author_detail?.rating

            val time = item.updated_at.replaceRange(10,item.updated_at.length,"")

            binding.tvuserRatingnDate.text = "${rating}/10 - $time"

            binding.tvContentReview.text = item.content

            val stringUri = item.author_detail?.avatar_path

            var uri = when(stringUri?.contains("/https://www.gravatar.com/avatar/")){
                true -> {
                    stringUri?.replace("/https://www.gravatar.com/avatar/", "https://www.gravatar.com/avatar/")
                }else ->{
                    IMAGE_URL+stringUri
                }
            }

            Glide.with(itemView.context)
                .load(uri)
                .into(binding.ivUserAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_review, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size
}