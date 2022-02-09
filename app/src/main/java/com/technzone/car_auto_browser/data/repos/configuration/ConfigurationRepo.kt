package com.technzone.car_auto_browser.data.repos.configuration

import com.technzone.car_auto_browser.common.CommonEnums
import com.technzone.car_auto_browser.data.api.response.APIResource
import com.technzone.car_auto_browser.data.api.response.ResponseWrapper
import com.technzone.car_auto_browser.data.models.configuration.ConfigurationWrapperResponse

interface ConfigurationRepo {

    fun setAppLanguage(selectedLanguage: CommonEnums.Languages)
    fun getAppLanguage(): CommonEnums.Languages

    suspend fun loadConfigurationData(): APIResource<ResponseWrapper<ConfigurationWrapperResponse>>
}