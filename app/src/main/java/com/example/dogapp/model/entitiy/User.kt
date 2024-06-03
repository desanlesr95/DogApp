package com.example.dogapp.model.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    @SerializedName("id") @PrimaryKey var id:Int = 0,
    @SerializedName("name") @ColumnInfo(name = "name") var name:String = "",
    @SerializedName("lastname") @ColumnInfo(name = "lastname") var lastname:String = "",
    @SerializedName("mail")@ColumnInfo(name = "mail") var mail:String = "",
    @SerializedName("phone") @ColumnInfo(name = "phone")var phone:String = "",
    @ColumnInfo(name = "token") var token: String = ""
)
