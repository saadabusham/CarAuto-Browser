package com.technzone.car_auto_browser.ui.auth.forgetpassword.fragments

import androidx.fragment.app.activityViewModels
import com.technzone.car_auto_browser.R
import com.technzone.car_auto_browser.data.api.response.ResponseSubErrorsCodeEnum
import com.technzone.car_auto_browser.data.common.CustomObserverResponse
import com.technzone.car_auto_browser.data.models.auth.login.UserDetailsResponseModel
import com.technzone.car_auto_browser.databinding.FragmentVerificationForgetPasswordBinding
import com.technzone.car_auto_browser.ui.base.fragment.BaseBindingFragment
import com.technzone.car_auto_browser.utils.extensions.showErrorAlert
import com.technzone.car_auto_browser.utils.extensions.validate
import com.technzone.car_auto_browser.utils.validation.ValidatorInputTypesEnums
import com.technzone.car_auto_browser.ui.auth.forgetpassword.viewmodels.ForgetPasswordViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_verification_forget_password.*
import kotlinx.android.synthetic.main.layout_toolbar.*

@AndroidEntryPoint
class VerificationForgetPasswordFragment :
    BaseBindingFragment<FragmentVerificationForgetPasswordBinding>() {

    private val viewModel: ForgetPasswordViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_verification_forget_password

    override fun onViewVisible() {
        super.onViewVisible()
        addToolbar(
            hasToolbar = true,
            toolbarView = toolbar,
            hasBackButton = true,
            showBackArrow = true,
            hasTitle = true,
            title = R.string.empty_string
        )
        setUpViewsListeners()
        setUpData()
    }

    private fun setUpData() {
        binding?.viewModel = viewModel
        viewModel.startHandleResendSignUpPinCodeTimer()
    }

    private fun sendOtpResultObserver(): CustomObserverResponse<String> {
        return CustomObserverResponse(
            requireActivity(),
            object : CustomObserverResponse.APICallBack<String> {
                override fun onSuccess(
                    statusCode: Int,
                    subErrorCode: ResponseSubErrorsCodeEnum,
                    data: String?
                ) {
                    viewModel.userIdMutableLiveData.postValue(data)
                    viewModel.startHandleResendSignUpPinCodeTimer()
                }
            })
    }

    private fun verifyOtpResultObserver(): CustomObserverResponse<UserDetailsResponseModel> {
        return CustomObserverResponse(requireActivity(), object : CustomObserverResponse.APICallBack<UserDetailsResponseModel> {
            override fun onSuccess(statusCode: Int, subErrorCode: ResponseSubErrorsCodeEnum, data: UserDetailsResponseModel?) {
                data?.let {
                    navigationController.navigate(R.id.action_verificationForgetPassword_to_recoveryPasswordFragment)
                }
            }
        })
    }

    private fun setUpViewsListeners() {
        otp_view.setAnimationEnable(true)
        binding?.tvTimeToResend?.setOnClickListener {
            if (viewModel.signUpResendPinCodeEnabled.value == true) {
                viewModel.resendVerificationCode().observe(this, sendOtpResultObserver())
            }
        }
        binding?.btnConfirm?.setOnClickListener {
            if (validateInput()) {
                viewModel.verifyCode().observe(this,verifyOtpResultObserver())
            }
        }
    }

    private fun validateInput(): Boolean {
        otp_view.text.toString().validate(ValidatorInputTypesEnums.OTP, requireContext()).let {
            if (!it.isValid) {
                activity.showErrorAlert(it.errorTitle, it.errorMessage)
                return false
            }
        }
        return true
    }

}