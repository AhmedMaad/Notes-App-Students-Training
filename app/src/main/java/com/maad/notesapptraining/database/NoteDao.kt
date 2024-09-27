package com.maad.notesapptraining.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)

}