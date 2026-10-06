package com.codepath.campgrounds

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

    @Dao
    interface CampgroundDao {
        @Query("SELECT * FROM campground_table")
        fun getAll(): Flow<List<CampgroundEntity>>

        @Insert
        fun insertAll(campgrounds: List<CampgroundEntity>)

        @Query("DELETE FROM campground_table")
        fun deleteAll()
    }
