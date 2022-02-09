package com.technzone.car_auto_browser.data.di

import android.content.Context
import com.technzone.car_auto_browser.data.pref.configuration.ConfigurationPref
import com.technzone.car_auto_browser.data.pref.configuration.ConfigurationPrefImp
import com.technzone.car_auto_browser.data.pref.user.UserPref
import com.technzone.car_auto_browser.data.pref.user.UserPrefImp
import com.technzone.car_auto_browser.utils.pref.SharedPreferencesUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PrefModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesUtil(@ApplicationContext context: Context): SharedPreferencesUtil {
        return SharedPreferencesUtil.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideConfigurationPref(preferencesUtil: SharedPreferencesUtil): ConfigurationPref {
        return ConfigurationPrefImp(preferencesUtil)
    }

    @Provides
    @Singleton
    fun provideUserPref(preferencesUtil: SharedPreferencesUtil): UserPref {
        return UserPrefImp(preferencesUtil)
    }
}