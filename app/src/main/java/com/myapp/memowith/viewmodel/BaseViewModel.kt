package com.myapp.memowith.viewmodel

import androidx.lifecycle.ViewModel
import com.myapp.memowith.navigator.BaseNavigator
import java.lang.ref.WeakReference

abstract class BaseViewModel<N : BaseNavigator> : ViewModel() {

    private var _navigator: WeakReference<N?>? = null
    var navigator: N?
        set(value) {
            _navigator = WeakReference(value)
        }
        get() = _navigator?.get()
}