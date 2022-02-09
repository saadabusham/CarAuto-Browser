package com.technzone.car_auto_browser.ui.webview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebStorage
import android.webkit.WebViewClient
import androidx.core.content.FileProvider
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.databinding.ActivityWebviewBinding
import com.technzone.car_auto_browser.ui.base.activity.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint
import java.io.File


@AndroidEntryPoint
class WebViewActivity : BaseBindingActivity<ActivityWebviewBinding>() {

    var webViewContent: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            layoutResID = R.layout.activity_webview,
            hasToolbar = true,
            hasBackButton = true,
            showBackArrow = true,
            hasTitle = false
        )
        WebStorage.getInstance().deleteAllData()
        binding?.webView?.settings?.javaScriptEnabled = true
        binding?.webView?.settings?.loadWithOverviewMode = true
        binding?.webView?.settings?.useWideViewPort = true
        binding?.webView?.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        binding?.webView?.settings?.domStorageEnabled = true
        binding?.webView?.settings?.loadWithOverviewMode = true
        binding?.webView?.settings?.useWideViewPort = true
        binding?.webView?.settings?.allowUniversalAccessFromFileURLs = true
        binding?.webView?.settings?.allowFileAccessFromFileURLs = true
        binding?.webView?.settings?.builtInZoomControls = true
        binding?.webView?.settings?.displayZoomControls = false
        binding?.webView?.settings?.setSupportMultipleWindows(true)

        binding?.webView?.settings?.javaScriptCanOpenWindowsAutomatically = true
        binding?.webView?.webViewClient = WebViewClient()

        binding?.webView?.loadUrl("https://www.youtube.com/")
    }
    fun installAPK(file: File?) {
        val intent: Intent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent = Intent(Intent.ACTION_INSTALL_PACKAGE)
            intent.data = getUri(file)
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK
        } else {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndTypeAndNormalize(
                Uri.fromFile(file),
                "application/vnd.android.package-archive"
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true)
        intent.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, "com.android.vending")
        applicationContext.startActivity(intent)
    }
    fun getUri(file: File?): Uri? {
        return FileProvider.getUriForFile(
            applicationContext,
            "sksa.aa.customapps.fileProvider",
            file!!
        )
    }
    companion object {
        fun start(context: Context?) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
    }

}