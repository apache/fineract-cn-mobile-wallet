package org.mifos.mobile_wallet_cn.auth.launcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.postDelayed
import androidx.navigation.fragment.findNavController
import org.mifos.mobile_wallet_cn.R
import org.mifos.mobile_wallet_cn.base.BaseFragment
import org.mifos.mobile_wallet_cn.databinding.FragmentLauncherBinding

class LauncherFragment : BaseFragment<FragmentLauncherBinding>() {

    private val splashScreenDuration: Long = 500

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLauncherBinding =
        FragmentLauncherBinding::inflate

    override fun setup() {
        showToolbar(View.GONE)
        view?.postDelayed(splashScreenDuration) {
            navLogin()
        }
    }

    private fun navLogin() {
        findNavController().navigate(R.id.action_launcherFragment_to_loginFragment)
    }
}