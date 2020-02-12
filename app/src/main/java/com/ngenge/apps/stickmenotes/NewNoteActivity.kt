package com.ngenge.apps.stickmenotes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ngenge.apps.stickmenotes.adapter.NotesListAdapter
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.layout_new_note.*
import java.util.*

class NewNoteActivity :AppCompatActivity() {
    private lateinit var noteViewModel:NotesViewModel
    private lateinit var adapter: NotesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_new_note)
        supportActionBar?.title = getString(R.string.new_note)

        noteViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_new_note,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.done_id) {
            insertNote()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun insertNote() {
        val title = titleEditText.text.toString().trim()
        val description = descriptionEditText.text.toString().trim()
        val date = Date()
        if (title.isNotEmpty() && description.isNotEmpty()) {
            val note = Note(description = description,title = title,dateUpdated = date)

            noteViewModel.insertNote(note)
            finish()
        } else {
            Toast.makeText(this,"Please provide the note title and body",Toast.LENGTH_LONG).show()
            return
        }
    }

    override fun onBackPressed() {
        insertNote()
        super.onBackPressed()
    }


}