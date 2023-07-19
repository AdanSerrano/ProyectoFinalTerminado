package com.example.proyectfinalds6

import com.example.proyectfinalds6.Models.NewsHeadlines

interface OnFetchDataListener<NewsApiResponse> {
    fun onFetchData(list: List<NewsHeadlines>, message: String)
    fun onError(message: String)
}