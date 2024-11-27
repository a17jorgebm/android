package com.example.tasklist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert //tamen se pode facer Upsert pa facer insert ou update se xa existe
    suspend fun insertNote(note: Note) //suspend faina asincrona, lanzando unha nova corrutina (un hilo liviano)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY dateAdded ASC")
    fun getNotesOrderedByDateAdded(): Flow<List<Note>>

    @Query("SELECT * FROM Note ORDER BY title ASC")
    fun getNotesOrderedByTitle(): Flow<List<Note>>
}