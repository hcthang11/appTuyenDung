package com.hcthang.apptuyendung.common.eventbus
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

class ElementBus(id: String) {
    val listAction: MutableList<BaseAction> = mutableListOf()
    val id: String = id
}