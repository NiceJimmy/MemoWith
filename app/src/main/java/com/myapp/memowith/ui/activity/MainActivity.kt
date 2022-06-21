package com.myapp.memowith.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.memowith.R
import com.example.memowith.databinding.MainActivityBinding
import com.example.memowith.ui.main.MainFragment
import com.myapp.memowith.ui.fragment.BaseFragment
import com.myapp.memowith.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : BaseActivity<MainActivityBinding>() {

    override fun getLayoutId(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        Timber.d("start_main")

    }

    override fun startActivity(action: Context.() -> Intent, vararg params: Pair<String, Any?>) {
        TODO("Not yet implemented")
    }

    override fun startActivity(activity: Class<out Activity>?, vararg params: Pair<String, Any?>) {
        TODO("Not yet implemented")
    }

    override fun startActivityForResult(
        action: Context.() -> Intent,
        requestCode: Int,
        vararg params: Pair<String, Any?>
    ) {
        TODO("Not yet implemented")
    }

    override fun startActivityForResult(
        activity: Class<out Activity>?,
        requestCode: Int,
        vararg params: Pair<String, Any?>
    ) {
        TODO("Not yet implemented")
    }

    override fun addFragment(baseFragment: BaseFragment<*>, tag: String) {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("aaaaaaaaaaaaa")
        Timber.d("asdfasdf")
    }


}