package com.myapp.memowith.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.memowith.R
import com.example.memowith.databinding.FragmentMyAlarmsBinding

class MyAlarmsFragment : BaseFragment<FragmentMyAlarmsBinding>() {
    companion object {
        fun newInstance(): MyAlarmsFragment = MyAlarmsFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_my_alarms

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding
    }
}