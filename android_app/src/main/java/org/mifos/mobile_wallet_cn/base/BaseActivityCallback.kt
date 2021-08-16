package org.mifos.mobile_wallet_cn.base

interface BaseActivityCallback {
    fun showToolbar(visibility: Int) {}

    fun setToolbarTitle(title: String?) {}

    fun showToolbarUserSection(visibility: Int) {}

    fun showBackButton(drawable: Int) {}

    fun hideBackButton() {}

    fun setSwipeRefreshEnabled(enabled: Boolean) {}

    fun showSwipeProgress() {}

    fun hideSwipeProgress() {}

    fun hideSoftKeyboard() {}
}