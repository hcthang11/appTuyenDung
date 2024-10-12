package com.b15d52nhom4.apptuyendung.ui

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import com.b15d52nhom4.apptuyendung.R

class CustomProgressDialog(context: Context?) : Dialog(context!!) {
    init {
        val params = window!!.attributes
        params.gravity = Gravity.CENTER_HORIZONTAL
        window!!.attributes = params
        setTitle(null)
        setCancelable(false)
        setOnCancelListener(null)
        val view = LayoutInflater.from(context).inflate(R.layout.layout_loading, null)
        setContentView(view)
    }
}