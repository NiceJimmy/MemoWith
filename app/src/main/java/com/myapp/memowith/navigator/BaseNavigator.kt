package com.myapp.memowith.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.myapp.memowith.ui.fragment.BaseFragment
import timber.log.Timber

interface BaseNavigator {

    fun startActivity(action: Context.() -> Intent, vararg params: Pair<String, Any?>)

    fun startActivity(activity: Class<out Activity>?, vararg params: Pair<String, Any?>)

    fun startActivityForResult(action: Context.() -> Intent, requestCode: Int, vararg params: Pair<String, Any?>)

    fun addFragment(baseFragment: BaseFragment<*>, tag: String)

    fun removeFragment(tag: String)

    fun findFragmentByTag(tag: String): Fragment?

    fun showFragment(tag: String, hideTag: String? = null)

    fun hideFragment(tag: String)

}