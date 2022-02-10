package com.technzone.car_auto_browser.ui.webview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebStorage
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.FileProvider
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.ui.base.activity.BaseBindingCarActivity
import java.io.File


class WebViewCarAutoActivity : BaseBindingCarActivity() {

    var webViewContent: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            layoutResID = R.layout.activity_webview,
            hasToolbar = false,
            hasBackButton = false,
            showBackArrow = false,
            hasTitle = false
        )
        val webView = findViewById(R.id.webView) as WebView
        WebStorage.getInstance().deleteAllData()
        webView.settings?.javaScriptEnabled = true
        webView.settings?.loadWithOverviewMode = true
        webView?.settings?.useWideViewPort = true
        webView?.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView?.settings?.domStorageEnabled = true
        webView?.settings?.loadWithOverviewMode = true
        webView?.settings?.useWideViewPort = true
        webView?.settings?.allowUniversalAccessFromFileURLs = true
        webView?.settings?.allowFileAccessFromFileURLs = true
        webView?.settings?.builtInZoomControls = true
        webView?.settings?.displayZoomControls = false
        webView?.settings?.setSupportMultipleWindows(true)

        webView?.settings?.javaScriptCanOpenWindowsAutomatically = true
        webView?.webViewClient = WebViewClient()

        webView?.loadUrl("https://www.youtube.com/")
    }
    companion object {
        fun start(context: Context?) {
            val intent = Intent(context, WebViewCarAutoActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
    }

}