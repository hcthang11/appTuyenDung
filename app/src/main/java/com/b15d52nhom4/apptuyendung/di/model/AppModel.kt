package com.b15d52nhom4.apptuyendung.di.model

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.b15d52nhom4.apptuyendung.data.local.AppDatabase
import com.b15d52nhom4.apptuyendung.data.remote.InteractCommon
import com.b15d52nhom4.apptuyendung.di.builder.ViewModelModule
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

@Module(includes = [ViewModelModule::class])
class AppModel {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "mvvm-database").allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    internal fun provideInteractCommon(): InteractCommon {
        return InteractCommon()
    }

    @Provides
    @Singleton
    internal fun provideSchedule(): Executor {
        return Executors.newFixedThreadPool(4)
    }
}