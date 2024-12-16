package com.hcthang.apptuyendung.di.component

import android.app.Application
import android.content.Context
import com.hcthang.apptuyendung.common.MVVMApplication
import com.hcthang.apptuyendung.data.local.AppDatabase
import com.hcthang.apptuyendung.data.remote.InteractCommon
import com.hcthang.apptuyendung.di.builder.ActivityBuilderModule
import com.hcthang.apptuyendung.di.builder.FragmentBuilderModule
import com.hcthang.apptuyendung.di.model.AppModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import java.util.concurrent.Executor
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,AppModel::class,AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class
    ])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: MVVMApplication)
    fun context() : Context
    fun appDatabase(): AppDatabase
    fun interactCommon(): InteractCommon
    fun schedule(): Executor

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }
}