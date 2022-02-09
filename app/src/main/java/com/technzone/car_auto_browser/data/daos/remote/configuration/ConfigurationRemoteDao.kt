package com.technzone.car_auto_browser.data.daos.remote.configuration

import com.technzone.car_auto_browser.data.api.response.ResponseWrapper
import com.technzone.car_auto_browser.data.models.configuration.ConfigurationWrapperResponse
import retrofit2.http.GET

interface ConfigurationRemoteDao {

    @GET("api/configuration")
    suspend fun getAppConfiguration(): ResponseWrapper<ConfigurationWrapperResponse>
}