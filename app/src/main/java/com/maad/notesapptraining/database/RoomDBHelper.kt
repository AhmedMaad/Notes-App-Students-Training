package com.maad.notesapptraining.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 2,
    exportSchema = true, //No need to write that
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class RoomDBHelper : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDBHelper? = null

        fun getInstance(context: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {

                val instance = Room
                    .databaseBuilder(context, RoomDBHelper::class.java, "DB")
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }
        }

    }

}