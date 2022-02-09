package com.technzone.car_auto_browser.data.repos.lookups

import com.technzone.car_auto_browser.data.api.response.APIResource
import com.technzone.car_auto_browser.data.api.response.ResponseWrapper
import com.technzone.car_auto_browser.data.models.general.Countries
import com.technzone.car_auto_browser.data.models.general.ListWrapper

interface LookupsRepo {
    suspend fun getCountriesCode(
        pageSize: Int,
        pageNumber: Int,
        name: String? = "",
        code: String? = ""
    ): APIResource<ResponseWrapper<ListWrapper<Countries>>>
}