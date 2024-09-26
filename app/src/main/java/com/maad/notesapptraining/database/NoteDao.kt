package com.maad.notesapptraining.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {

    @Upsert
    fun upsertNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<Note>

    @Delete
    fun deleteNote(note: Note)

}