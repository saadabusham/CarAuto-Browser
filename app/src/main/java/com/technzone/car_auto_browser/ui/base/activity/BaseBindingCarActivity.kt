package com.technzone.car_auto_browser.ui.base.activity

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.google.android.apps.auto.sdk.CarActivity
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.data.api.response.ResponseSubErrorsCodeEnum
import com.technzone.car_auto_browser.ui.base.dialogs.CustomDialogUtils
import com.technzone.car_auto_browser.utils.extensions.longToast
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseBindingCarActivity : CarActivity(),
    IBaseBindingActivity {
    var rootView: View? = null

    lateinit var customDialogUtils: CustomDialogUtils
    override fun showLoadingView() {
        customDialogUtils.showProgress()
    }

    override fun hideLoadingView() {
        customDialogUtils.hideProgress()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        customDialogUtils = CustomDialogUtils(this, withProgress = true, isShowNow = false)
        super.onCreate(savedInstanceState)
    }

    open fun setContentView(
        layoutResID: Int,
        hasToolbar: Boolean = false,
        hasBackButton: Boolean = false,
        toolbarView: Toolbar? = null,
        backArrowTint: Int? = null,
        hasTitle: Boolean = false,
        title: Int = R.string.empty_string,
        titleString: String? = null,
        hasSubTitle: Boolean = false,
        subTitle: Int = R.string.empty_string,
        showBackArrow: Boolean = false,
        @DrawableRes navigationIcon: Int? = null
    ) {
        if (isBindingEnabled()) {

            super.setContentView(layoutResID)
            rootView = rootView
        } else {
            super.setContentView(layoutResID)
        }

        addToolbar(
            hasToolbar,
            toolbarView,
            hasBackButton,
            backArrowTint,
            hasTitle,
            title,
            titleString,
            hasSubTitle,
            subTitle,
            showBackArrow,
            navigationIcon
        )
    }

    override fun addToolbar(
        hasToolbar: Boolean,
        toolbarView: Toolbar?,
        hasBackButton: Boolean,
        backArrowTint: Int?,
        hasTitle: Boolean,
        title: Int,
        titleString: String?,
        hasSubTitle: Boolean,
        subTitle: Int,
        showBackArrow: Boolean,
        navigationIcon: Int?
    ) {

    }

    override fun updateToolbarTitle(
        hasTitle: Boolean,
        @StringRes title: Int,
        titleString: String?
    ) {

    }

    override fun updateToolbarTitle(
        hasTitle: Boolean,
        title: Int,
        titleString: String?,
        hasBackButton: Boolean,
        backArrowTint: Int?,
        showBackArrow: Boolean
    ) {

    }

    override fun updateToolbarSubTitle(
        hasSubTitle: Boolean,
        @StringRes subTitle: Int,
        subTitleString: String?
    ) {

    }

    override fun handleRequestFailedMessages(
        errorCode: Int?,
        subErrorCode: ResponseSubErrorsCodeEnum?,
        requestMessage: String?
    ) {
//        this.let {
//            HandleRequestFailedUtil.handleRequestFailedMessages(
//                it,
//                subErrorCode,
//                requestMessage
//            )
//        }
    }

    override fun startActivity(intent: Intent?) =
        super.startActivity(
            intent, ActivityOptions.makeCustomAnimation(
                this,
                R.anim.slide_in_end, R.anim.slide_out_left
            ).toBundle()
        )

    fun handleError(throwable: Throwable?) {
        when (throwable) {
            is IOException -> {
                longToast(getString(R.string.error_no_internet))
            }
            is SocketTimeoutException -> {
                longToast(getString(R.string.error_server))
            }
            is HttpException -> {

            }
            else -> {
                longToast(getString(R.string.error_msg))
            }
        }
    }

    fun showUnAuthorizedDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.session_ended))
        val dialog: AlertDialog = builder.create()

        builder.setNeutralButton(R.string.ok) { _, _ ->
            dialog.dismiss()
        }

        builder.setOnDismissListener {
        }

        builder.show()
    }

}