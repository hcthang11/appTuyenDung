package com.b15d52nhom4.apptuyendung.ui.base.callback

import com.b15d52nhom4.apptuyendung.ui.base.BaseViewUI
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface BaseCallBack : BaseViewUI {
    fun error(id: String, error: Throwable)
}