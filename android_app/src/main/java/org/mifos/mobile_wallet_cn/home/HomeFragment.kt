package org.mifos.mobile_wallet_cn.home

import android.view.LayoutInflater
import android.view.ViewGroup
import org.mifos.mobile_wallet_cn.base.BaseFragment
import org.mifos.mobile_wallet_cn.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun setup() {
        TODO("Not yet implemented")
    }

}