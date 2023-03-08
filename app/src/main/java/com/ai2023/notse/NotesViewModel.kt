package com.ai2023.notse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
   private val repository: NotesRepository
     val allNotes: LiveData<List<Notes1Data>>
    init {
        val dao = NoteDataBase.getDatabase(application).getNoteDao()
         repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }
        fun deleteNote(notes1Data: Notes1Data)=viewModelScope.launch(Dispatchers.IO) {
            repository.delete(notes1Data)
        }

        fun insertNote(notes1Data: Notes1Data)=viewModelScope.launch(Dispatchers.IO) {
            repository.insert(notes1Data)
        }
}