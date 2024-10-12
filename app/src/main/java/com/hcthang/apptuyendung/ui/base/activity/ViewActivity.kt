package com.hcthang.apptuyendung.ui.base.activity

import android.os.Bundle
import android.view.View
import com.hcthang.apptuyendung.ui.base.BaseViewUI
import com.hcthang.apptuyendung.ui.base.fragment.BaseFragment
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