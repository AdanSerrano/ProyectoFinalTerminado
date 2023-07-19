package com.example.proyectfinalds6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsaplication.CustomViewHolder
import com.example.proyectfinalds6.Models.NewsHeadlines
import com.squareup.picasso.Picasso

class CustomAdapter(private val context: Context, private val headlines: List<NewsHeadlines>, private val listener: SelectListener) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val headline = headlines[position]

        holder.text_title.text = headline.title
        holder.text_source.text = headline.source?.name

        headline.urlToImage?.let {
            Picasso.get().load(it).into(holder.img_headline)
        }

        holder.cardView.setOnClickListener {
            listener.onNewsClicked(headline)
        }
    }

    override fun getItemCount(): Int {
        return headlines.size
    }
}