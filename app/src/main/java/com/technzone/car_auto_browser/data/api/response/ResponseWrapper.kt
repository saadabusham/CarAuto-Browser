package com.technzone.car_auto_browser.data.api.response

data class ResponseWrapper<RETURN_MODEL>(

    val success: Boolean,
    val code: Int,
    val message: String,
    val data: RETURN_MODEL?
)