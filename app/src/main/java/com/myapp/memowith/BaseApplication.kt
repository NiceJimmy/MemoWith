package com.myapp.memowith


import android.annotation.SuppressLint
import android.app.Application
import android.content.Context



import common.di.DataComponent
import common.di.module.ApplicationModule
import dagger.internal.DaggerGenerated

class BaseApplication : Application() {

    //Application 클래스는 가장 먼저 인스턴스화 된다.

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: BaseApplication
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun shared(): BaseApplication {
            return instance
        }

        var component: DataComponent
            get() = instance.mDataComponent
            set(value) {
                instance.mDataComponent = value
            }

    }

    init {
        instance = this
    }

    private lateinit var mDataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun getDataComponent() : DataComponent {
        return mDataComponent
    }

    //    private fun initDagger() {
//
//        mDataComponent = DaggerDataComponent.builder()
//            .applicationModule(ApplicationModule(this))
//            .dataModule(DataModule())
//            .build()
//
//    }
//    private fun initDagger() {
//        mDataComponent = DaggerDataComponent.builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
//    }

}