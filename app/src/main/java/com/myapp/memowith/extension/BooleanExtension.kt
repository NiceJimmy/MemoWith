package com.myapp.memowith.extension

fun <T> Boolean.takeOne(whenTrue: T, whenFalse: T): T {
    return if(this) whenTrue else whenFalse
}