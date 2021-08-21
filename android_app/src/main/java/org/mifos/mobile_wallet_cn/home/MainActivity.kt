package org.mifos.mobile_wallet_cn.home

import android.view.LayoutInflater
import android.view.View
import org.mifos.mobile_wallet_cn.base.BaseActivity
import org.mifos.mobile_wallet_cn.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun setup() {
        return
    }

    override fun showToolbar(visibility: Int) {
        binding.toolbar.container.visibility = visibility
    }

    override fun setToolbarTitle(title: String?) {
        binding.toolbar.toolbarTitle.text = title
    }

    override fun showToolbarUserSection(visibility: Int) {
        binding.toolbar.userGreetSection.visibility = visibility
        if (visibility == View.VISIBLE) {
            binding.toolbar.userFirstName.text = "Kinar"
        }
    }
}