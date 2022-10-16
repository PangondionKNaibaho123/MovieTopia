package com.example.movietopia.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietopia.R
import com.example.movietopia.databinding.LayoutIcustomItemDropdownBinding
import com.example.movietopia.model.utils.DataCustomDropdown

class CustomDropdownAdapter(
    var data: ArrayList<DataCustomDropdown>,
    private var listener: DropdownListener
): RecyclerView.Adapter<CustomDropdownAdapter.ItemViewHolder>()
{
    var dataToShow = ArrayList<String>()
    private lateinit var binding: LayoutIcustomItemDropdownBinding


    inner class ItemViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(item: DataCustomDropdown){
            binding = LayoutIcustomItemDropdownBinding.bind(itemView)
            binding.tvLabel.text = item.name
            when(item.isSelected){
                true -> binding.ivCheck.visibility = View.VISIBLE
                false -> binding.ivCheck.visibility = View.GONE
            }
            binding.root.setOnClickListener {
                listener.onItemSelected(item)
            }
        }
    }

    interface DropdownListener{
        fun onItemSelected(item: DataCustomDropdown)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_icustom_item_dropdown, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size
}