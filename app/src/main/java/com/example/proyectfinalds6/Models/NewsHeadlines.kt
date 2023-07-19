package com.example.proyectfinalds6.Models

import java.io.Serializable

class NewsHeadlines : Serializable {
    var source: Source? = null
    var author: String = ""
    var title: String = ""
    var description: String = ""
    var url: String = ""
    var urlToImage: String = ""
    var publishedAt: String = ""
    var content: String = ""

}