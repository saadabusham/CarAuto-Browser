package com.technzone.car_auto_browser.ui.splash

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.technzone.car_auto_browser.data.api.response.APIResource
import com.technzone.car_auto_browser.data.enums.UserEnums
import com.technzone.car_auto_browser.data.models.auth.login.UserDetailsResponseModel
import com.technzone.car_auto_browser.data.pref.configuration.ConfigurationPref
import com.technzone.car_auto_browser.data.pref.user.UserPref
import com.technzone.car_auto_browser.data.repos.user.UserRepo
import com.technzone.car_auto_browser.data.repos.configuration.ConfigurationRepo
import com.technzone.car_auto_browser.ui.base.viewmodel.BaseViewModel
import com.technzone.car_auto_browser.utils.LocaleUtil
import com.technzone.car_auto_browser.utils.pref.SharedPreferencesUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userRepo: UserRepo,
    private val configurationRepo: ConfigurationRepo,
    private val sharedPreferencesUtil: SharedPreferencesUtil,
    private val userPref: UserPref,
    private val configurationPref: ConfigurationPref
) : BaseViewModel() {

    fun getConfigurationData() = liveData {
        emit(APIResource.loading())
        val response = configurationRepo.loadConfigurationData()
        emit(response)
    }

    fun updateAccessToken() = liveData {
        emit(APIResource.loading())
        val response = userRepo.refreshToken(userRepo.getUser()?.refreshToken?.refreshToken ?: "")
        emit(response)
    }

    fun logout() = viewModelScope.launch {
        sharedPreferencesUtil.clearPreference()
        userPref.setIsFirstOpen(false)
        configurationPref.setAppLanguageValue(LocaleUtil.getLanguage())
    }

    fun storeUser(user: UserDetailsResponseModel) {
        userRepo.setUser(user)
    }
    fun isUserLoggedIn() = userRepo.getUserStatus() == UserEnums.UserState.LoggedIn
}