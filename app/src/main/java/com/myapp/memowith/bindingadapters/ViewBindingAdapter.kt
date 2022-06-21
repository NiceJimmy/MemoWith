package com.myapp.memowith.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.myapp.memowith.ui.views.OnSafeClickListener

@BindingAdapter("onSafeClick")
fun View.setOnSafeClickListener(clickListener: View.OnClickListener?) {
    clickListener?.also {
        setOnClickListener(OnSafeClickListener(it))
    } ?: setOnClickListener(null)
}