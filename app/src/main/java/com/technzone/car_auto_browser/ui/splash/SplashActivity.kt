package com.technzone.car_auto_browser.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.ui.base.activity.BaseBindingActivity
import com.technzone.car_auto_browser.ui.webview.WebViewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseBindingActivity() {

    private val viewModel: SplashViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            layoutResID = R.layout.activity_splash,
            hasToolbar = false
        )
        Handler(Looper.getMainLooper()).postDelayed({
            goToNextPage()
        }, 3000)

        RuntimeException("This is a RUNTIME EXCEPTION")
    }

    private fun goToNextPage() {
        WebViewActivity.start(this)
    }

    override fun onNewIntent(intent: Intent?) {
        this.intent = intent
        super.onNewIntent(intent)
    }


    companion object {

        fun start(context: Context?) {
            val intent = Intent(context, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }

    }

}