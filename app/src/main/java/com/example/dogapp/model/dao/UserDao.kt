package com.example.dogapp.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dogapp.model.entitiy.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("SELECT count(id) from user")
    fun getUserLogged():Int


}