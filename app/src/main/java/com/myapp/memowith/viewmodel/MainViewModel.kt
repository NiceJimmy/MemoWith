package com.myapp.memowith.viewmodel

import android.content.Context
import com.myapp.memowith.navigator.BaseNavigator
import com.myapp.memowith.ui.activity.SharingActivity
import timber.log.Timber
import java.lang.ref.WeakReference
import javax.inject.Inject

class MainViewModel @Inject constructor(
    context: Context
): BaseViewModel<BaseNavigator>() {
    // TODO: Implement the ViewModel
    private val mContextRef = WeakReference(context)
    private val mContext: Context?
        get() = mContextRef.get()

    fun tabHomeMenu() {

    }

    fun tabFriendsList() {

    }

    fun tabQuickMenu() {

    }
}