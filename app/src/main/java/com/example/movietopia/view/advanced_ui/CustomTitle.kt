package com.example.movietopia.view.advanced_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.movietopia.R
import com.example.movietopia.databinding.LayoutCustomTitleBinding

class CustomTitle: ConstraintLayout {

    private lateinit var mContext: Context
    private lateinit var binding: LayoutCustomTitleBinding
    private var listener: SeeAllListener?= null

    constructor(context: Context): super(context){
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?){
        mContext = context
        binding = LayoutCustomTitleBinding.bind(
            LayoutInflater.from(mContext).inflate(R.layout.layout_custom_title, this, true)
        )
        binding.tvSeeAll.setOnClickListener {
            listener?.onSeeAllSelected()
        }
    }

    fun setListener(listener: SeeAllListener?){
        this.listener = listener
    }

    fun setTitle(textInput: String){
        binding.tvMovieCategory.text = textInput
    }

    interface SeeAllListener{
        fun onSeeAllSelected()
    }
}