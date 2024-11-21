package com.example.dogapp.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.dogapp.model.entitiy.Pet
import com.example.dogapp.model.entitiy.PetWithPhoto
import com.example.dogapp.model.entitiy.RecentProfilePhoto

@Dao
interface PetDao {
    @Transaction
    @Query("Select * From Pet Where id = :id")
    fun getPetWithPhoto(id: Int): List<PetWithPhoto>

    @Transaction
    @Query("Select * From Pet ")
    fun getPetWithPhotoAll(): List<PetWithPhoto>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPet(pet: Pet)

    @Insert
    fun insertRecentProfilePhone(photo: RecentProfilePhoto):Long

}