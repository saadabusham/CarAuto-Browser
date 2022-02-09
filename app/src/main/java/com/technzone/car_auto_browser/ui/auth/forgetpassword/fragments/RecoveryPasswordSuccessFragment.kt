package com.technzone.car_auto_browser.ui.auth.forgetpassword.fragments

import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.databinding.FragmentRecoveryPasswordSuccessBinding
import com.technzone.car_auto_browser.ui.base.fragment.BaseBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecoveryPasswordSuccessFragment :
    BaseBindingFragment<FragmentRecoveryPasswordSuccessBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_recovery_password_success

    override fun onViewVisible() {
        super.onViewVisible()
        setUpViewsListeners()
    }

    private fun setUpViewsListeners() {
        binding?.btnLogin?.setOnClickListener {
            requireActivity().finish()
        }
    }
}