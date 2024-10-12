package com.b15d52nhom4.apptuyendung.ui.xample

import com.b15d52nhom4.apptuyendung.R
import com.b15d52nhom4.apptuyendung.databinding.ActivityMainBinding
import com.b15d52nhom4.apptuyendung.ui.base.activity.BaseMVVMActivity
import com.b15d52nhom4.apptuyendung.ui.utils.OpenFragmentUtils

class MainActivity : BaseMVVMActivity<MainCallBack, MainViewModel>(), MainCallBack {

    override fun getLayoutMain() = R.layout.activity_main

    override fun setEvents() {
    }

    override fun initComponents() {
        getBindingData().viewModel = mModel
        OpenFragmentUtils.openUserFragment(supportFragmentManager)
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun error(id: String, error: Throwable) {
        showMessage(error.message!!)
    }

    override fun getBindingData() = mBinding as ActivityMainBinding

}