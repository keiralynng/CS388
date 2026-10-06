package com.codepath.campgrounds

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "campground_table")
data class CampgroundEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "latLong") val latLong: String?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String?
)