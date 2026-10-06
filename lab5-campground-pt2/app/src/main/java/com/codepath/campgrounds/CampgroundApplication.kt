package com.codepath.campgrounds

import android.app.Application

class CampgroundApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}