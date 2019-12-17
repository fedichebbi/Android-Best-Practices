package com.example.tutorialreso.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tutorialreso.data.db.entity.CurrentWeatherEntry
import com.example.tutorialreso.utils.converters.StringConverter

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)

@TypeConverters(value = [(StringConverter::class)])
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java, "forecast.db")
                .build()
    }
}