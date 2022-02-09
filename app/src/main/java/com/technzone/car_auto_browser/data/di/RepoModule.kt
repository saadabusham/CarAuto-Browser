package com.technzone.car_auto_browser.data.di


import com.technzone.car_auto_browser.data.repos.user.UserRepo
import com.technzone.car_auto_browser.data.repos.user.UserRepoImp
import com.technzone.car_auto_browser.data.repos.configuration.ConfigurationRepo
import com.technzone.car_auto_browser.data.repos.configuration.ConfigurationRepoImp
import com.technzone.car_auto_browser.data.repos.lookups.LookupsRepo
import com.technzone.car_auto_browser.data.repos.lookups.LookupsRepoImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun bindConfigurationRepo(configurationRepoImp: ConfigurationRepoImp): ConfigurationRepo

    @Singleton
    @Binds
    abstract fun bindUserRepo(userRepoImp: UserRepoImp) : UserRepo

    @Singleton
    @Binds
    abstract fun bindLookUpsRepo(lookupsRepoImp: LookupsRepoImp): LookupsRepo


}