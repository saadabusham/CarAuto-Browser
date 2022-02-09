package com.technzone.car_auto_browser.utils.extensions

import android.app.Activity
import com.tapadoo.alerter.Alerter
import com.technzone.car_auto_browser.R

fun Activity?.showErrorAlert(title: String = "", message: String) {
    Alerter.create(this)
        .setTitle(title)
        .setTitleAppearance(R.style.AlertTextAppearance)
        .setText(message)
        .setTextAppearance(R.style.AlertTextAppearance)
        .setBackgroundColorRes(R.color.alert_red) // or setBackgroundColorInt(Color.CYAN)
        .show()
}

//fun Activity.showUpdateDialog(updateStatus: UpdateStatus) {
//    UpdateAppDialog(this,updateStatus)
//        .show()
//}