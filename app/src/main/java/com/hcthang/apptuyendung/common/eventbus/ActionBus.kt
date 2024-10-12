package com.hcthang.apptuyendung.common.eventbus
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface ActionBus<Data> :BaseAction {
    fun call(data: Data)
}