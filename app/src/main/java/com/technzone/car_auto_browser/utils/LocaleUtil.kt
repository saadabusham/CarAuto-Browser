package com.technzone.car_auto_browser.utils

import java.util.*

class LocaleUtil {

    companion object {
        fun getLanguage(): String {
            return getLocal().language
        }

        fun getLocal(): Locale {
            return Locale.getDefault()
        }
    }
}