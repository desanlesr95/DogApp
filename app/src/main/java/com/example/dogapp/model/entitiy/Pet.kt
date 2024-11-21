package com.example.dogapp.model.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity
class Pet(){
    @SerializedName("id") @PrimaryKey var id:Int=0
   @ColumnInfo(name = "recent_profile_photo_id") var RecentProfilePhoto_id: Int?= null
    @SerializedName("name") @ColumnInfo(name = "name") var name:String=""
    @SerializedName("pet_type") @ColumnInfo(name = "pet_type") var pet_type:Int=0
    @SerializedName("gender") @ColumnInfo(name= "gender") var gender:Int=0
    @SerializedName("age") @ColumnInfo(name= "age") var age:Int= 0
    @SerializedName("breed") @ColumnInfo(name = "breed") var breed:String=""
    @SerializedName("color") @ColumnInfo(name= "color") var color:String=""
    @SerializedName("owner") @ColumnInfo(name = "owner") var owner:Int=0
    @Ignore @SerializedName("recent_profile_photo") var profilePhoto:RecentProfilePhoto? = null
    override fun toString(): String {
        return "Pet(id=$id, RecentProfilePhoto_id=$RecentProfilePhoto_id, name='$name', pet_type=$pet_type, gender=$gender, age=$age, breed='$breed', color='$color', owner=$owner)"
    }


}