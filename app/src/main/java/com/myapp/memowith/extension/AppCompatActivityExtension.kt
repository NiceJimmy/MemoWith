package com.myapp.memowith.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.transact {
        add(frameId, fragment, tag)
    }
}

fun AppCompatActivity.removeFragmentFromActivity(tag: String) {
    supportFragmentManager.apply {
        findFragmentByTag(tag)?.let {
            transact {
                remove(it)
            }
        }
    }
}

fun AppCompatActivity.showFragmentInActivity(tag: String, hideTag: String? = null) {
    supportFragmentManager.apply {
        hideTag?.let {
            hideFragmentFromActivity(hideTag)
        }
        findFragmentByTag(tag)?.let {
            transact {
                show(it)
            }
        }
    }
}

fun AppCompatActivity.hideFragmentFromActivity(tag: String) {
    supportFragmentManager.apply {
        findFragmentByTag(tag)?.let {
            transact {
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