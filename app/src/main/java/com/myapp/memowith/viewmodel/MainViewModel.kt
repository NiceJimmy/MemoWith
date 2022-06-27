package com.myapp.memowith.viewmodel

import android.content.Context
import com.myapp.memowith.extension.takeOne
import com.myapp.memowith.navigator.BaseNavigator
import com.myapp.memowith.ui.fragment.FriendAlarmsFragment
import com.myapp.memowith.ui.fragment.MyAlarmsFragment
import timber.log.Timber
import java.lang.ref.WeakReference
import javax.inject.Inject

class MainViewModel @Inject constructor(
    context: Context
): BaseViewModel<BaseNavigator>() {
    // TODO: Implement the ViewModel
    private val mContextRef = WeakReference(context)
    private val mContext: Context?
        get() = mContextRef.get()


    private enum class FragmentTag {
        MyList,
        FriendsList;

        val isMyList: Boolean
        get() = this == MyList
    }






    private fun showFragment(tag: FragmentTag, hideTag: FragmentTag? = null) {
        tag.name.let { showTag ->

            val fragment = navigator?.findFragmentByTag(showTag)

            if (fragment != null) {
                Timber.d("check_tag : ${showTag} and ${hideTag}")
                navigator?.showFragment(showTag, hideTag?.name)
                } else { //back stack 에 fragment가 없는 상태, 신규로 add를 해준다.
                Timber.d("check_tag_isNull? : ${showTag} / ${hideTag} / ${fragment} / ${tag.isMyList}")
                    hideTag?.name?.let {hideTagName ->
                        navigator?.hideFragment(hideTagName)
                    }

                    navigator?.addFragment(
                        tag.isMyList.takeOne(MyAlarmsFragment.newInstance(), FriendAlarmsFragment.newInstance())
                        ,showTag)

            }
        }
    }

    fun showMyList() {
        showFragment(FragmentTag.MyList, FragmentTag.FriendsList)
    }

    fun tabMyList() {
        showFragment(FragmentTag.MyList, FragmentTag.FriendsList)
    }

    fun tabFriendsList() {
        showFragment(FragmentTag.FriendsList, FragmentTag.MyList)
    }

    fun tabQuickMenu() {

    }
}