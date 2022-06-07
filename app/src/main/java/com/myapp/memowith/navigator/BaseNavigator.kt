package com.myapp.memowith.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.myapp.memowith.ui.fragment.BaseFragment

interface BaseNavigator {
    fun startActivity(action: Context.() -> Intent, vararg params: Pair<String, Any?>)

    fun startActivity(activity: Class<out Activity>?, vararg params: Pair<String, Any?>)

    fun startActivityForResult(action: Context.() -> Intent, requestCode: Int, vararg params: Pair<String, Any?>)

    fun startActivityForResult(activity: Class<out Activity>?, requestCode: Int, vararg params: Pair<String, Any?>)

    fun addFragment(baseFragment: BaseFragment<*>, tag: String)
}