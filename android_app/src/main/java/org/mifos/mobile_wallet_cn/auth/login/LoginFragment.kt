package org.mifos.mobile_wallet_cn.auth.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.mifos.mobile_wallet_cn.R
import org.mifos.mobile_wallet_cn.auth.AuthActivity
import org.mifos.mobile_wallet_cn.base.BaseFragment
import org.mifos.mobile_wallet_cn.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding =
        FragmentLoginBinding::inflate

    override fun setup() {
        showToolbar(View.GONE)
        binding.loginBtn.setOnClickListener {
            (activity as AuthActivity).navHomeActivity()
        }
        binding.signupBtn.setOnClickListener {
            navSignUp()
        }
    }

    private fun navSignUp() {
        findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
    }
}