package com.example.dogapp.model.entitiy

import androidx.room.Embedded
import androidx.room.Relation

data class PetWithPhoto (
    @Embedded val pet: Pet,
    @Relation(
        parentColumn = "recent_profile_photo_id",
        entityColumn = "id"
    )
    val recentProfilePhoto: RecentProfilePhoto?

)