package com.example.dogapp.model.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class RecentProfilePhoto (
 @PrimaryKey(autoGenerate = true)  val id: Int,
 @SerializedName ("url_photo")@ColumnInfo(name = "url_photo") var url_photo:String= "",
 @SerializedName("update_at")@ColumnInfo(name = "update")  var update_at:String=""
) {
 override fun toString(): String {
  return "RecentProfilePhoto(url_photo='$url_photo', update_at='$update_at')"
 }
}