package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddNoteBinding


class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NotesDataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //create a binding
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //access database
        db = NotesDataBaseHelper(this)

        //storing data only happens if user click save button
        binding.saveBtn1.setOnClickListener{
            val title = binding.editTextText.text.toString()
            val content = binding.editTextTextMultiLine.text.toString()
            //pass the data to Note class
            val note = Note(0,title,content)
            db.insertNote(note)
            //close the addnote activity then it will move to mainActivity
            finish()
            Toast.makeText(this,"Note saved",Toast.LENGTH_SHORT).show()
        }
    }
}