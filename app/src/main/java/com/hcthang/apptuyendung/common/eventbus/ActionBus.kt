package com.hcthang.apptuyendung.common.eventbus

interface ActionBus<Data> :BaseAction {
    fun call(data: Data)
}