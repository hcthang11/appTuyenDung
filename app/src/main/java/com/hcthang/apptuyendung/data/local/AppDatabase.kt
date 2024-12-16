package com.hcthang.apptuyendung.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hcthang.apptuyendung.data.local.dao.UserDao
import com.hcthang.apptuyendung.data.model.UserExample

@Database(entities = arrayOf(UserExample::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun fileDao() : FileDao
    abstract fun userDao() : UserDao
}