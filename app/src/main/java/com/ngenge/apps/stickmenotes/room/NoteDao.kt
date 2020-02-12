package com.ngenge.apps.stickmenotes.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ngenge.apps.stickmenotes.Note


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Insert
    suspend fun insertNotes(vararg notes: Note)

    @Query("SELECT * from notes_table ORDER BY dateUpdated DESC")
    fun getNotes():LiveData<List<Note>>

    @Query("DELETE FROM notes_table WHERE note_id =:id")
    suspend fun deleteNote(id:Int)

    @Delete
    suspend fun deleteNotes(notes:List<Note>)

}