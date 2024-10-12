package com.b15d52nhom4.apptuyendung.ui.base.activity

import android.os.Bundle
import android.view.View
import com.b15d52nhom4.apptuyendung.ui.base.BaseViewUI
import com.b15d52nhom4.apptuyendung.ui.base.fragment.BaseFragment
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface ViewActivity : BaseViewUI{

    fun onCreateControl(savedInstanceState: Bundle?)

    fun onDestroyControl()

    fun findFragmentByTag(tag: String): BaseFragment

    fun setViewRoot(viewRoot: View)

    fun onBackParent()

    fun onStartControl()

    fun onStopControl()
}