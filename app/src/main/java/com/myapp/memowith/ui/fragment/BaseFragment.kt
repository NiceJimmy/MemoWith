package com.myapp.memowith.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.memowith.R
import com.myapp.memowith.BaseApplication
import com.myapp.memowith.navigator.BaseNavigator
import com.myapp.memowith.ui.activity.BaseActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding> : Fragment(), BaseNavigator{
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: B

    protected var baseActivity: BaseActivity<*>? = null

    @LayoutRes
    abstract fun getLayoutId(): Int


    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("${javaClass.simpleName}: onAttach")
        if (context is BaseActivity<*>) {
            baseActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = BaseApplication.shared().getDataComponent().viewModelFactory
        Timber.d("${javaClass.simpleName}: onCreate")
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("${javaClass.simpleName}: onCreateView")
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("${javaClass.simpleName}: onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("${javaClass.simpleName}: onActivityCreated")
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

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("${javaClass.simpleName}: onDestroyView")
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${javaClass.simpleName}: onDestroy")
    }

    @CallSuper
    override fun onDetach() {
        super.onDetach()
        Timber.d("${javaClass.simpleName}: onDetach")
        baseActivity = null
    }

    override fun startActivity(action: Context.() -> Intent, vararg params: Pair<String, Any?>) {
        baseActivity?.startActivity(action, *params)
    }

    override fun startActivity(activity: Class<out Activity>?, vararg params: Pair<String, Any?>) {
        baseActivity?.startActivity(activity, *params)
    }

    override fun startActivityForResult(action: Context.() -> Intent, requestCode: Int, vararg params: Pair<String, Any?>) {
        TODO("Not yet implemented")
    }

    override fun addFragment(baseFragment: BaseFragment<*>, tag: String) {
        baseActivity?.addFragment(baseFragment, tag)
    }

    override fun removeFragment(tag: String) {
        baseActivity?.removeFragment(tag)
    }

    override fun showFragment(tag: String, hideTag: String?) {
        baseActivity?.showFragment(tag, hideTag)
    }

    override fun hideFragment(tag: String) {
        baseActivity?.hideFragment(tag)
    }

    override fun findFragmentByTag(tag: String) = baseActivity?.findFragmentByTag(tag)
}