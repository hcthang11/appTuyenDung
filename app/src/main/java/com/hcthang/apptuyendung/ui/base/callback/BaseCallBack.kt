package com.hcthang.apptuyendung.ui.base.callback

import com.hcthang.apptuyendung.ui.base.BaseViewUI
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface BaseCallBack : BaseViewUI {
    fun error(id: String, error: Throwable)
}