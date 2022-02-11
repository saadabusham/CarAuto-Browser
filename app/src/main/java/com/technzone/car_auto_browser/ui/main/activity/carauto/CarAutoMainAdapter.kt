package com.technzone.car_auto_browser.ui.main.activity.carauto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebStorage
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.data.models.CarAutoPageItem
import com.technzone.car_auto_browser.ui.base.adapters.BaseBindingRecyclerViewAdapter
import com.technzone.car_auto_browser.ui.base.adapters.BaseViewHolder

class CarAutoMainAdapter(
    context: Context
) : BaseBindingRecyclerViewAdapter<CarAutoPageItem>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_webview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(items[position])
        }
    }

    inner class ViewHolder(private val binding: View) :
        BaseViewHolder<CarAutoPageItem>(binding) {
        var webView: WebView? = null
        var refreshLayout: SwipeRefreshLayout? = null
        var loaded:Boolean = false
        override fun bind(item: CarAutoPageItem) {
            if(!loaded) {
                webView = binding.findViewById(R.id.webView) as WebView
                refreshLayout = binding.findViewById(R.id.swipRefresh) as SwipeRefreshLayout
                setUpWebView(item.url)
                setUpRefreshLayout()
            }
        }

        private fun setUpWebView(url:String) {
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

            webView?.loadUrl(url)
        }

        private fun setUpRefreshLayout() {
            refreshLayout?.setOnRefreshListener {
                refreshLayout?.isRefreshing = false
                webView?.reload()
            }
        }

    }
}