package com.maad.notesapptraining.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maad.notesapptraining.database.Note
import com.maad.notesapptraining.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(app: Application) : AndroidViewModel(app) {

    private val db: RoomDBHelper = RoomDBHelper.getInstance(app)

    fun upsertNote(note: Note) = db.noteDao.upsertNote(note)

    fun deleteNote(note: Note) = db.noteDao.deleteNote(note)

    fun getNotes() = db.noteDao.getAllNotes()

}

