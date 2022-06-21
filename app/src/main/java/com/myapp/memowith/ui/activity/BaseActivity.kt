package com.myapp.memowith.ui.activity


import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.memowith.R
import com.myapp.memowith.BaseApplication
import com.myapp.memowith.navigator.BaseNavigator
import com.myapp.memowith.ui.fragment.BaseFragment
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), BaseNavigator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: B

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${javaClass.simpleName}: onCreate")
        viewModelFactory = BaseApplication.shared().getDataComponent().viewModelFactory
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
        Timber.d("${javaClass.simpleName}: onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${javaClass.simpleName}: onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("${javaClass.simpleName}: onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("${javaClass.simpleName}: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${javaClass.simpleName}: onDestroy")
    }


}