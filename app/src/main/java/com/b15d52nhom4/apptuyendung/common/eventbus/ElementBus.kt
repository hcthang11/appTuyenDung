package com.b15d52nhom4.apptuyendung.common.eventbus
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

class ElementBus(id: String) {
    val listAction: MutableList<BaseAction> = mutableListOf()
    val id: String = id
}