package com.b15d52nhom4.apptuyendung.ui.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.b15d52nhom4.apptuyendung.ui.base.BaseViewUI
import com.b15d52nhom4.apptuyendung.ui.base.activity.BaseActivity
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface ViewFragment : BaseViewUI {
    fun onCreateViewControl(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    fun onViewCreatedControl(view: View, savedInstanceState: Bundle?)

    fun onDestroyViewControl()

    fun reload(bundle: Bundle)

    fun getBaseActivity(): BaseActivity
}