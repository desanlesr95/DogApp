package com.example.dogapp.utils.singleton

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dogapp.R
import com.example.dogapp.model.dao.UserDao
import com.example.dogapp.model.entitiy.Pet
import com.example.dogapp.model.entitiy.User

@Database(entities = [User::class,Pet::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object{
        var app:AppDatabase?=null
        fun geInstance(context: Context):AppDatabase{
            if (app == null){
                app = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, context.getString(R.string.app_name)
                ).allowMainThreadQueries().build()
            }
            return this.app!!
        }
    }


}