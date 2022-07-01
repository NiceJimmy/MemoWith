package com.myapp.memowith.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memowith.R
import com.example.memowith.databinding.FragmentMyAlarmsBinding
import com.myapp.memowith.viewmodel.MyAlarmsViewModel
import common.recyclerview.AlarmListAdapter

class MyAlarmsFragment : BaseFragment<FragmentMyAlarmsBinding>() {
    companion object {
        fun newInstance(): MyAlarmsFragment = MyAlarmsFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_my_alarms

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myAlarmRecyclerview.adapter = AlarmListAdapter(binding)
        binding.myAlarmRecyclerview.layoutManager = LinearLayoutManager(context)

    }
}