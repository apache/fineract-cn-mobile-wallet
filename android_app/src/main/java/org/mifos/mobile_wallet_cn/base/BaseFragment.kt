package org.mifos.mobile_wallet_cn.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private val TAG: String = "AppDebug"

    private var callback: BaseActivityCallback? = null

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(layoutInflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callback = context as BaseActivityCallback
        } catch (e: ClassCastException) {
            Log.e(TAG, "$context must implement BaseActivityCallback")
        }
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun setup()

    protected fun showToolbar(visibility: Int) {
        callback?.showToolbar(visibility)
    }

    protected fun setToolbarTitle(title: String?) {
        callback?.setToolbarTitle(title)
    }

    protected fun showToolbarUserSection(visibility: Int) {
        callback?.showToolbarUserSection(visibility)
    }

    protected fun showBackButton(drawable: Int) {
        callback?.showBackButton(drawable)
    }

    protected fun hideBackButton() {
        callback?.hideBackButton()
    }

    protected fun setSwipeRefreshEnabled(enabled: Boolean) {
        callback?.setSwipeRefreshEnabled(enabled)
    }

    protected fun showSwipeProgress() {
        callback?.showSwipeProgress()
    }

    protected fun hideSwipeProgress() {
        callback?.hideSwipeProgress()
    }

    protected fun hideSoftKeyboard() {
        callback?.hideSoftKeyboard()
    }
}