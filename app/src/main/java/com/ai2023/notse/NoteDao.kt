package com.ai2023.notse

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(notes1Data:Notes1Data)

    @Delete
     fun delete(notes1Data:Notes1Data)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Notes1Data>>



}