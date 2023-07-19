package com.example.newsaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.proyectfinalds6.Models.NewsHeadlines
import com.example.proyectfinalds6.R
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    private lateinit var headlines: NewsHeadlines
    private lateinit var txt_title: TextView
    private lateinit var txt_author: TextView
    private lateinit var txt_time: TextView
    private lateinit var txt_detail: TextView
    private lateinit var txt_content: TextView
    private lateinit var img_news: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        txt_title = findViewById(R.id.text_detail_title)
        txt_author = findViewById(R.id.text_detail_author)
        txt_time = findViewById(R.id.text_detail_time)
        txt_detail = findViewById(R.id.text_detail_detail)
        txt_content = findViewById(R.id.text_detail_content)
        img_news = findViewById(R.id.img_detail_news)

        headlines = intent.getSerializableExtra("data") as NewsHeadlines

        txt_title.text = headlines.title
        txt_author.text = headlines.author
        txt_time.text = headlines.publishedAt
        txt_detail.text = headlines.description
        txt_content.text = headlines.content
        Picasso.get().load(headlines.urlToImage).into(img_news)
    }
}