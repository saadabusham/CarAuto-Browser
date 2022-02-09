package com.technzone.car_auto_browser.ui.base.views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.technzone.car_auto_browser.R


class AppTextInputEditText @JvmOverloads constructor(
    context: Context,
    private var attrs: AttributeSet,
    defStyleAttr: Int = R.attr.editTextStyle
) : TextInputEditText(context, attrs, defStyleAttr) {

}