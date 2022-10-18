package com.example.movietopia.view.advanced_ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.movietopia.R
import com.example.movietopia.databinding.PopupFailureBinding

interface PopUpDialogListener{
    fun onClickListener()
}

fun Activity.showPopUpDialog(
    textDesc: String,
    listener: PopUpDialogListener?=null
){
    val dialog = Dialog(this)
    val binding = PopupFailureBinding.bind(layoutInflater.inflate(R.layout.popup_failure, null))
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setContentView(binding.root)
    dialog.setCancelable(listener == null)
    binding.apply {
        tvPopUpWarning.text = textDesc
        btnPopUpWarning.setOnClickListener {
            listener?.onClickListener()
            dialog.dismiss()
        }
        if(!isFinishing) dialog.show()
    }
}