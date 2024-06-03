package com.example.dogapp.model.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity
class Pet(){
    @SerializedName("id") @PrimaryKey var id:Int=0
    @SerializedName("name") @ColumnInfo(name = "name") var name:String=""
    @SerializedName("pet_type") @ColumnInfo(name = "pet_type") var pet_type:Boolean=false
    @SerializedName("gender") @ColumnInfo(name= "gender") var gender:Boolean=false
    @SerializedName("age") @ColumnInfo(name= "age") var age:Int= 0
    @SerializedName("breed") @ColumnInfo(name = "breed") var breed:String=""
    @SerializedName("color") @ColumnInfo(name= "color") var color:String=""
    @SerializedName("owner") @ColumnInfo(name = "owner") var owner:String=""
}