package com.technzone.car_auto_browser.service.auto

import com.google.android.apps.auto.sdk.CarActivity
import com.google.android.apps.auto.sdk.CarActivityService
import com.technzone.car_auto_browser.ui.main.activity.carauto.MainCarActivity
import com.technzone.car_auto_browser.ui.webview.WebViewCarAutoActivity

class CarAutoService : CarActivityService() {

    override fun getCarActivity(): Class<out CarActivity> {
        return MainCarActivity::class.java
    }
}