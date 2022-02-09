package com.technzone.car_auto_browser.utils.extensions

import android.widget.TextView

fun TextView.textLines(): Int {
    if (this == null) return 0
    return this.lineCount
}

fun TextView.margitStart(dimen: Int) {
    this.margitStart(dimen)
}

