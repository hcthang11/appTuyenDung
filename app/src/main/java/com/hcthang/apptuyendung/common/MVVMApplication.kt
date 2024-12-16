package com.hcthang.apptuyendung.common

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.hcthang.apptuyendung.di.component.AppComponent
import com.hcthang.apptuyendung.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MVVMApplication : MultiDexApplication(), HasAndroidInjector{
    lateinit var appComponent: AppComponent
        get

    @Inject
    internal lateinit var androidDispatchingInjector: DispatchingAndroidInjector<Any>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    fun appDatabase() = appComponent.appDatabase()
    fun interactCommon() = appComponent.interactCommon()
    fun schedule() = appComponent.schedule()

    override fun androidInjector(): AndroidInjector<Any> {
        return androidDispatchingInjector;
    }

}