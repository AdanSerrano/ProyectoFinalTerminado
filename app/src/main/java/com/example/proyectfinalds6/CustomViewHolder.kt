package com.example.newsaplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import com.example.proyectfinalds6.R

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text_title: TextView = itemView.findViewById(R.id.text_title)
    val text_source: TextView = itemView.findViewById(R.id.text_source)
    val img_headline: ImageView = itemView.findViewById(R.id.img_headline)
    val cardView: CardView = itemView.findViewById(R.id.main_container)
}