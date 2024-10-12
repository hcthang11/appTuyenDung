package com.b15d52nhom4.apptuyendung.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.b15d52nhom4.apptuyendung.data.local.dao.UserDao
import com.b15d52nhom4.apptuyendung.data.model.UserExample
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

@Database(entities = arrayOf(UserExample::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun fileDao() : FileDao
    abstract fun userDao() : UserDao
}