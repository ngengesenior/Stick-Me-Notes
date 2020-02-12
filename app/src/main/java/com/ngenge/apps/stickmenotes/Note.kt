package com.ngenge.apps.stickmenotes

import android.os.Parcelable
import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    val id:Int?=null,
    @ColumnInfo(name = "note_title")
    var title:String?,
    @ColumnInfo(name = "note_description")
    var description:String,
    @ColumnInfo
    val dateUpdated:Date
):Parcelable {

}

fun Date.toReadableFormat():String {
    val simpleDateFormat = SimpleDateFormat("yyyy-mm-dd hh:mm")
    return simpleDateFormat.format(this)
}