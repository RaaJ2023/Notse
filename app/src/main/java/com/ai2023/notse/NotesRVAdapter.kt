package com.ai2023.notse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener:INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    val allNotes=ArrayList<Notes1Data>()
        inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            val textView=itemView.findViewById<TextView>(R.id.textView123)
            val deleteclk=itemView.findViewById<ImageView>(R.id.imgView123)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
    val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteclk.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
    return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }

    fun updateList(newList:List<Notes1Data>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()

    }
}

interface INotesRVAdapter{
    fun onItemClicked(notes1Data: Notes1Data)
}