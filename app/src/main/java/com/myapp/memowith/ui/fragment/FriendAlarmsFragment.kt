package com.myapp.memowith.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.memowith.R
import com.example.memowith.databinding.FragmentFriendAlarmsBinding

class FriendAlarmsFragment : BaseFragment<FragmentFriendAlarmsBinding>() {
    companion object {
        fun newInstance(): FriendAlarmsFragment = FriendAlarmsFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_friend_alarms

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding
    }
}