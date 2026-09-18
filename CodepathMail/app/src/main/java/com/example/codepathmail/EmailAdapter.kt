package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter (private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        return ViewHolder(contactView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.dateTextView.text = email.date

        if(email.isRead){
            holder.senderTextView.setTypeface(null, Typeface.NORMAL) //null means dont give it diff font here
            holder.titleTextView.setTypeface(null, Typeface.ITALIC)
            holder.summaryTextView.setTypeface(null, Typeface.NORMAL)
            holder.dateTextView.setTypeface(null, Typeface.NORMAL)

        } else {
            holder.senderTextView.setTypeface(null, Typeface.BOLD)
            holder.titleTextView.setTypeface(null, Typeface.BOLD_ITALIC)
            holder.summaryTextView.setTypeface(null, Typeface.BOLD)
            holder.dateTextView.setTypeface(null, Typeface.BOLD)

        }

        holder.itemView.setOnClickListener { //when this specific row is clicked
            email.isRead = true

            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
            holder.titleTextView.setTypeface(null, Typeface.ITALIC)
            holder.summaryTextView.setTypeface(null, Typeface.NORMAL)
            holder.dateTextView.setTypeface(null, Typeface.NORMAL)


        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView:  TextView
        val dateTextView: TextView
        init{
            senderTextView = itemView.findViewById(R.id.sender)
            titleTextView = itemView.findViewById(R.id.title)
            summaryTextView = itemView.findViewById(R.id.summary)
            dateTextView = itemView.findViewById(R.id.date)
        }
    }
}