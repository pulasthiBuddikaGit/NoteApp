package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddNoteBinding
import com.example.todoapp.databinding.ActivityUpdateNoteBinding

class UpdateNoteActivity : AppCompatActivity() {

    //initialize binding          //this is xml file of update_note
    private lateinit var binding: ActivityUpdateNoteBinding
    private lateinit var db: NotesDataBaseHelper
    //-1 represent the noteId is empty
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_update)
        setContentView(binding.root)

        db = NotesDataBaseHelper(this)

        //receive the id which is coming from notesAdapter
        noteId = intent.getIntExtra("note_id",-1)
        //noteId is empty
        if(noteId == -1){
            finish()
            return
        }
        //we need to know which note is clicked for that we use getNoteById method
        val note = db.getNoteById(noteId)
        //we receive title and content when we call this function so to get them
        binding.updateTitleEditText.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        //update old note with new note
        binding.updateSaveBtn.setOnClickListener{
            //take the new title and content
            val newTitle = binding.updateTitleEditText.text.toString()
            val newContent = binding.updateContentEditText.text.toString()

            //pass new data to Note class
            val updatedNote = Note(noteId, newTitle,newContent)
            db.updateNote(updatedNote)
            //after updating note return back to mainActivity
            finish()
            Toast.makeText(this,"Changes saved",Toast.LENGTH_SHORT).show()
        }

    }
}