package com.hcthang.apptuyendung.common.eventbus

class ElementBus(id: String) {
    val listAction: MutableList<BaseAction> = mutableListOf()
    val id: String = id
}