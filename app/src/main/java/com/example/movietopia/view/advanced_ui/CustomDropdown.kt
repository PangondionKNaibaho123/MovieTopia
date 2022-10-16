package com.example.movietopia.view.advanced_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.movietopia.R
import com.example.movietopia.databinding.LayoutCustomDropdownBinding
import com.example.movietopia.databinding.LayoutPopupCustomDropdownBinding
import com.example.movietopia.model.utils.DataCustomDropdown
import com.example.movietopia.view.adapter.CustomDropdownAdapter

class CustomDropdown: ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: LayoutCustomDropdownBinding
    private var listener: DropdownListener?= null

    private lateinit var listItem: List<DataCustomDropdown>

    private lateinit var dropdownAdapter: CustomDropdownAdapter
    private lateinit var popUpBinding: LayoutPopupCustomDropdownBinding
    private lateinit var popUpWindow: PopupWindow
    private var isDropdownShown: Boolean = false

    constructor(context: Context): super(context){

    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs){

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){

    }

    private fun init(context: Context, attrs: AttributeSet){
        mContext = context

        binding = LayoutCustomDropdownBinding.bind(
            LayoutInflater.from(mContext).inflate(R.layout.layout_custom_dropdown, this, true)
        )

        binding.spinnerInput.setOnClickListener {
            listener?.onClickInput()
            if(listItem.size>0){
                binding.spinnerInput.performClick()
            }
            isDropdownShown = !isDropdownShown

        }
    }

    interface DropdownListener{
        fun onClickInput(){}
        fun onItemSelected(item: DataCustomDropdown){}
        fun onNothingSelected(resetIcon: Boolean){}
    }
}