package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//this adapter is responsible for provide the views that represent in a data set
class NotesAdapter(private var notes: List<Note>, context: Context): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item , parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        //user entered values will be display in these views
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }

    //refresh the notes when new note added
    fun refreshData(newNotes : List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }
}