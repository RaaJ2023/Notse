package com.ai2023.notse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="notes_table" )
class Notes1Data(@ColumnInfo(name="text")val text:String) {
    @PrimaryKey(autoGenerate = true) var id= 0


}