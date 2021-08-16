package org.mifos.mobile_wallet_cn.auth

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import org.mifos.mobile_wallet_cn.base.BaseActivity
import org.mifos.mobile_wallet_cn.databinding.ActivityAuthBinding
import org.mifos.mobile_wallet_cn.home.MainActivity

class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityAuthBinding =
        ActivityAuthBinding::inflate

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

    public fun navHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}