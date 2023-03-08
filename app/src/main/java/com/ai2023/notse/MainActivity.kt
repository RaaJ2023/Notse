package com.ai2023.notse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ai2023.notse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), INotesRVAdapter {




    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv123.layoutManager=LinearLayoutManager(this)
        val adapter= NotesRVAdapter(this,this)
        binding.rv123.adapter=adapter




        viewModel=ViewModelProvider(this,
                     ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let{
                adapter.updateList(it)
            }


        })


    }

    override fun onItemClicked(notes1Data: Notes1Data) {
        viewModel.deleteNote(notes1Data)
        Toast.makeText(this,"${notes1Data.text}Deleted",Toast.LENGTH_SHORT).show()
    }

    fun SubmitData(view: View) {

        val noteText= binding.edtinput.text.toString()
        if (noteText.isNotEmpty()){
            viewModel.insertNote(Notes1Data(noteText))
            Toast.makeText(this,"$noteText.Inserted",Toast.LENGTH_SHORT).show()

        }
    }
}