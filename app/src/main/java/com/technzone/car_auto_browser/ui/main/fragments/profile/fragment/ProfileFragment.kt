package com.technzone.car_auto_browser.ui.main.fragments.profile.fragment

import android.view.View
import android.webkit.WebStorage
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.data.common.Constants
import com.technzone.car_auto_browser.ui.base.fragment.BaseBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseBindingFragment(){

    var webView: WebView? = null
    var refreshLayout: SwipeRefreshLayout? = null

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onViewVisible() {
        super.onViewVisible()
        webView = rootView?.findViewById(R.id.webView) as WebView
        refreshLayout = rootView?.findViewById(R.id.swipRefresh) as SwipeRefreshLayout
        setUpWebView()
        setUpRefreshLayout()
        setUpListeners()
        setUpWebView()
    }

    private fun setUpListeners() {

    }

    private fun setUpWebView() {
        WebStorage.getInstance().deleteAllData()
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.loadWithOverviewMode = true
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

        webView?.loadUrl(Constants.GOOGLE)
    }

    private fun setUpRefreshLayout() {
        refreshLayout?.setOnRefreshListener {
            refreshLayout?.isRefreshing = false
            webView?.reload()
        }
    }

}