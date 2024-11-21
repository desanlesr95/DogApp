package com.example.dogapp.utils.singleton

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dogapp.R
import com.example.dogapp.model.dao.PetDao
import com.example.dogapp.model.dao.UserDao
import com.example.dogapp.model.entitiy.Pet
import com.example.dogapp.model.entitiy.RecentProfilePhoto
import com.example.dogapp.model.entitiy.User

@Database(entities = [User::class,Pet::class,RecentProfilePhoto::class], version = 7)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract  fun getPetDao():PetDao

    companion object{
        var app:AppDatabase?=null
        fun getInstance(context: Context):AppDatabase{
            if (app == null){
                app = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, context.getString(R.string.app_name)
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return this.app!!
        }
    }


}