package com.example.proyectfinalds6.Models

import java.io.Serializable

class NewsApiResponse : Serializable {
    var status: String? = null
    var totalResult: Int = 0
    var articles: List<NewsHeadlines>? = null
}