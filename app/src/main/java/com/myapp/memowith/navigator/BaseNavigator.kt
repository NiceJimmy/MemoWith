package com.myapp.memowith.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.myapp.memowith.ui.fragment.BaseFragment
import timber.log.Timber

interface BaseNavigator {

    fun startActivity(action: Context.() -> Intent, vararg params: Pair<String, Any?>)

    fun startActivity(activity: Class<out Activity>?, vararg params: Pair<String, Any?>)

    fun startActivityForResult(action: Context.() -> Intent, requestCode: Int, vararg params: Pair<String, Any?>)

}