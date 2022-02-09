package com.technzone.car_auto_browser.data.pref.configuration

interface ConfigurationPref {

    fun setAppLanguageValue(selectedLanguageValue: String)
    fun getAppLanguageValue():String
}