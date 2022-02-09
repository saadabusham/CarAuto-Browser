package com.technzone.car_auto_browser.data.repos.configuration

import com.technzone.car_auto_browser.common.CommonEnums
import com.technzone.car_auto_browser.data.api.response.APIResource
import com.technzone.car_auto_browser.data.api.response.ResponseHandler
import com.technzone.car_auto_browser.data.api.response.ResponseWrapper
import com.technzone.car_auto_browser.data.daos.remote.configuration.ConfigurationRemoteDao
import com.technzone.car_auto_browser.data.models.configuration.ConfigurationWrapperResponse
import com.technzone.car_auto_browser.data.pref.configuration.ConfigurationPref
import com.technzone.car_auto_browser.data.repos.base.BaseRepo
import javax.inject.Inject

class ConfigurationRepoImp @Inject constructor(
    responseHandler: ResponseHandler,
    private val configurationRemoteDao: ConfigurationRemoteDao,
    private val configurationPref: ConfigurationPref
) : BaseRepo(responseHandler), ConfigurationRepo {

    override fun setAppLanguage(selectedLanguage: CommonEnums.Languages) {
        configurationPref.setAppLanguageValue(selectedLanguage.value)
    }

    override fun getAppLanguage(): CommonEnums.Languages {
        return CommonEnums.Languages.getLanguageByValue(configurationPref.getAppLanguageValue())
    }

    override suspend fun loadConfigurationData():
            APIResource<ResponseWrapper<ConfigurationWrapperResponse>> {
        return try {
            responseHandle.handleSuccess(configurationRemoteDao.getAppConfiguration())
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }

}