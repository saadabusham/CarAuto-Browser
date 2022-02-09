package com.technzone.car_auto_browser.ui.base.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel(){


    var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable?.dispose()
        compositeDisposable = null
    }

}