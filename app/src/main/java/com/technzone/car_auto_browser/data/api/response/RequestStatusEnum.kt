package com.technzone.car_auto_browser.data.api.response

enum class RequestStatusEnum {
    SUCCESS,
    FAILED,
    LOADING;

    companion object {
        fun getRequestStatusByPosition(position: Int): RequestStatusEnum {
            return when (position) {
                0 -> SUCCESS
                1 -> FAILED
                else -> LOADING
            }
        }
    }
}