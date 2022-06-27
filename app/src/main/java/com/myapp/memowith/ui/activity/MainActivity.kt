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

class MainActivity : BaseActivity<MainActivityBinding>()  {

    override fun getLayoutId(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java).apply {
            navigator = this@MainActivity

            showMyList()
        }

    }



}