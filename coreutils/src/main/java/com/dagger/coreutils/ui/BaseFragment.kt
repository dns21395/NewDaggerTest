package com.dagger.coreutils.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagger.coreutils.ComponentManager
import com.dagger.coreutils.DaggerComponent

abstract class BaseFragment : Fragment() {

    abstract val layoutRes: Int
    protected lateinit var componentBuilder: () -> DaggerComponent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutRes, container, false)

    protected inline fun <reified T : DaggerComponent> getComponent(): T =
        ComponentManager.getOrPutComponent(this.javaClass.simpleName, componentBuilder) as T

    open fun onBackPressed() {

    }

    private fun isRealRemoving(): Boolean = isRemoving || ((parentFragment as? BaseFragment)?.isRealRemoving() ?: false)

    //It will be valid only for 'onDestroy()' method
    fun needCloseScope(): Boolean =
        when {
            activity?.isChangingConfigurations == true -> false
            activity?.isFinishing == true -> true
            else -> isRealRemoving()
        }
}