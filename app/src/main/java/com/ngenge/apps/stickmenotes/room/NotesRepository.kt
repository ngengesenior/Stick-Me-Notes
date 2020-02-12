package com.ngenge.apps.stickmenotes.room

import androidx.lifecycle.LiveData
import com.ngenge.apps.stickmenotes.Note

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes:LiveData<List<Note>> = noteDao.getNotes()

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    suspend fun deleteNote(noteId:Int) {
        noteDao.deleteNote(noteId)
    }

    suspend fun deleteNotes(notes:List<Note>) {
        noteDao.deleteNotes(notes)
    }

}