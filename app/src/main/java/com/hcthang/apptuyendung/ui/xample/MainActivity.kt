package com.hcthang.apptuyendung.ui.xample

import com.hcthang.apptuyendung.R
import com.hcthang.apptuyendung.databinding.ActivityMainBinding
import com.hcthang.apptuyendung.ui.base.activity.BaseMVVMActivity
import com.hcthang.apptuyendung.ui.utils.OpenFragmentUtils

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