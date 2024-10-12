package com.b15d52nhom4.apptuyendung.di.component

import android.app.Application
import android.content.Context
import com.b15d52nhom4.apptuyendung.common.MVVMApplication
import com.b15d52nhom4.apptuyendung.data.local.AppDatabase
import com.b15d52nhom4.apptuyendung.data.remote.InteractCommon
import com.b15d52nhom4.apptuyendung.di.builder.ActivityBuilderModule
import com.b15d52nhom4.apptuyendung.di.builder.FragmentBuilderModule
import com.b15d52nhom4.apptuyendung.di.model.AppModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import java.util.concurrent.Executor
import javax.inject.Singleton
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

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