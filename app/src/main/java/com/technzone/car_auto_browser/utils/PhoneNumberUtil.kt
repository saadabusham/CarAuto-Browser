package com.technzone.car_auto_browser.utils


object PhoneNumberUtil {

    fun removeFirstZerosOrPlus(phoneNumber: String): String {
        if (phoneNumber.startsWith(prefix = "00")) {
            return phoneNumber.removePrefix("00")
        } else if (phoneNumber.startsWith(prefix = "+")) {
            return phoneNumber.removePrefix("+")
        }
        return phoneNumber
    }
}