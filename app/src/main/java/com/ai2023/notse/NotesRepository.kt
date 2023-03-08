package com.ai2023.notse

import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NoteDao) {

        val allNotes: LiveData<List<Notes1Data>> = noteDao.getAllNotes()

        suspend fun insert(notes1Data: Notes1Data){

            noteDao.insert(notes1Data)
        }

    suspend fun delete(notes1Data: Notes1Data){

        noteDao.delete(notes1Data)
    }


}