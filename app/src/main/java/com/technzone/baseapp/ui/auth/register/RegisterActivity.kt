package com.technzone.baseapp.ui.auth.register

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.technzone.baseapp.R
import com.technzone.baseapp.data.common.Constants
import com.technzone.baseapp.databinding.ActivityRegisterBinding
import com.technzone.baseapp.ui.base.activity.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : BaseBindingActivity<ActivityRegisterBinding>() {

    companion object {
        const val REQUEST_CODE = 1
        fun start(
                context: Context?
        ) {
            val intent = Intent(context, RegisterActivity::class.java)
            context?.startActivity(intent)
        }

        fun startForResult(
                context: Activity?,
                isActivityResult: Boolean
        ) {
            val intent = Intent(context, RegisterActivity::class.java)
            intent.putExtra(Constants.BundleData.IS_ACTIVITY_RESULT, isActivityResult)
            context?.startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register, hasToolbar = false)
    }

}