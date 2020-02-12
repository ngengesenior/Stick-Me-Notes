package com.ngenge.apps.stickmenotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ngenge.apps.stickmenotes.room.NoteDatabase
import com.ngenge.apps.stickmenotes.room.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel (application: Application):AndroidViewModel(application) {
    private val repository:NotesRepository
    val allNotes:LiveData<List<Note>>

    init {
        val notesDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NotesRepository(notesDao)
        allNotes = repository.allNotes
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }

    fun deleteNote(noteId:Int) {
        viewModelScope.launch {
            repository.deleteNote(noteId)
        }
    }

    fun deleteNotes(notes:List<Note>) {
        viewModelScope.launch {
            repository.deleteNotes(notes)
        }
    }
}