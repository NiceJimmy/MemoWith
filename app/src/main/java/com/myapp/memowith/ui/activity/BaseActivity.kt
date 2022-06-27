package com.myapp.memowith.ui.activity


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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

    override fun startActivity(action: Context.() -> Intent, vararg params: Pair<String, Any?>) {
        val intent = action(this)
        startActivity(intent)
    }

    override fun startActivity(activity: Class<out Activity>?, vararg params: Pair<String, Any?>) {
        startActivity({ Intent(this, activity) }, *params)
    }

    override fun startActivityForResult(action: Context.() -> Intent, requestCode: Int, vararg params: Pair<String, Any?>) {
        TODO("Not yet implemented")
    }

    override fun findFragmentByTag(tag: String) = supportFragmentManager.findFragmentByTag(tag)

    override fun addFragment(baseFragment: BaseFragment<*>, tag: String) {
        supportFragmentManager.transact {
            Timber.d("check_baseFragment : ${baseFragment}")
            add(R.id.framelayout_fragment, baseFragment, tag)
        }
    }

    override fun removeFragment(tag: String) {
        supportFragmentManager.apply {
            findFragmentByTag(tag)?.let {
                transact {
                    remove(it)
                }
            }
        }
    }

    override fun showFragment(tag: String, hideTag: String?) {
        supportFragmentManager.apply {
            hideTag?.let {
                hideFragment(hideTag)
            }
            findFragmentByTag(tag)?.let {
                transact {
                    show(it)
                }
            }
        }
    }

    override fun hideFragment(tag: String) {
        supportFragmentManager.apply {
            findFragmentByTag(tag)?.let {
                transact {
                    Timber.d("check_tag_isHide?? ${it}")
                    hide(it)
                }
            }
        }
    }

    private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
        beginTransaction().apply {
            action()
        }.commit()
    }

}