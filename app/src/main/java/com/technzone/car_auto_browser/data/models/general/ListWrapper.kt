package com.technzone.car_auto_browser.data.models.general

data class ListWrapper<M>(
    val data: ArrayList<M>?,
    val totalRows: Int?
)