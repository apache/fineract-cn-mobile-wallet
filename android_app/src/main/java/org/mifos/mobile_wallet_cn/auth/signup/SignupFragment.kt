package org.mifos.mobile_wallet_cn.auth.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.mifos.mobile_wallet_cn.R
import org.mifos.mobile_wallet_cn.base.BaseFragment
import org.mifos.mobile_wallet_cn.databinding.FragmentSignupBinding

class SignupFragment : BaseFragment<FragmentSignupBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSignupBinding = FragmentSignupBinding::inflate

    override fun setup() {
        showToolbar(View.VISIBLE)
        setToolbarTitle(resources.getString(R.string.sign_up))
        showToolbarUserSection(View.GONE)
    }
}