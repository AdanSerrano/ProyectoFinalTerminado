package com.example.proyectfinalds6

import com.example.proyectfinalds6.Models.NewsHeadlines

interface SelectListener {
    fun onNewsClicked(newsHeadlines: NewsHeadlines)
}