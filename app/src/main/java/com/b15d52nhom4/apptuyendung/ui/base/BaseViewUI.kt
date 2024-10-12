package com.b15d52nhom4.apptuyendung.ui.base

import androidx.databinding.ViewDataBinding
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface BaseViewUI {
    fun getLayoutMain(): Int

    fun setEvents()

    fun initComponents()

    fun onBackRoot()

    fun showMessage(message: String)

    fun showMessage(messageId: Int)

    val isDestroyView: Boolean

    fun onResumeControl()

    fun onPauseControl()

    fun hideKeyBoard(): Boolean

    fun getBindingData(): ViewDataBinding

}