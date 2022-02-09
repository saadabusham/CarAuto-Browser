package com.technzone.car_auto_browser.data.repos.lookups

import com.technzone.car_auto_browser.data.api.response.APIResource
import com.technzone.car_auto_browser.data.api.response.ResponseHandler
import com.technzone.car_auto_browser.data.api.response.ResponseWrapper
import com.technzone.car_auto_browser.data.daos.remote.lookups.LookupsRemoteDao
import com.technzone.car_auto_browser.data.models.general.Countries
import com.technzone.car_auto_browser.data.models.general.ListWrapper
import com.technzone.car_auto_browser.data.repos.base.BaseRepo
import javax.inject.Inject

class LookupsRepoImp @Inject constructor(
    responseHandler: ResponseHandler,
    private val lookupsRemoteDao: LookupsRemoteDao
) : BaseRepo(responseHandler), LookupsRepo {

    override suspend fun getCountriesCode(
        pageSize: Int,
        pageNumber: Int,
        name: String?,
        code: String?
    ): APIResource<ResponseWrapper<ListWrapper<Countries>>> {
        return try {
            responseHandle.handleSuccess(
                lookupsRemoteDao.getCountriesCode(
                    pageSize, pageNumber, name, code
                )
            )
        } catch (e: Exception) {
            responseHandle.handleException(e)
        }
    }
}