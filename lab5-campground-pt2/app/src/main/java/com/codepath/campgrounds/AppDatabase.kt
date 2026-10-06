package com.codepath.campgrounds

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CampgroundEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun campgroundDao(): CampgroundDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Campgrounds-db"
            ).build()
    }
}