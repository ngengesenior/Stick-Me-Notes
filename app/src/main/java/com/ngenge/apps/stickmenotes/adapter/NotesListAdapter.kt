package com.ngenge.apps.stickmenotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ngenge.apps.stickmenotes.Note
import com.ngenge.apps.stickmenotes.R
import com.ngenge.apps.stickmenotes.toReadableFormat

class NotesListAdapter(var notesList: List<Note>):RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(inflater.inflate(R.layout.note_item_layout,parent,false))
    }

    override fun getItemCount() = notesList.size
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList.get(position)
        holder.bind(note)
    }

    fun setList(notes:List<Note>) {
        notesList = notes
        notifyDataSetChanged()
    }

}



class NoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val descriptionTextView:TextView = itemView.findViewById(R.id.descriptionTextView)
    val titleTextView:TextView = itemView.findViewById(R.id.titleTextView)
    val dateTextView:TextView = itemView.findViewById(R.id.dateTextView)

    fun bind(note: Note) {

        dateTextView.text = note.dateUpdated.toReadableFormat()
        titleTextView.text = note.title
        descriptionTextView.text = note.description
    }
}