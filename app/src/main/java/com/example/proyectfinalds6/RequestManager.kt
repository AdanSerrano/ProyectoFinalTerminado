package com.example.proyectfinalds6

import android.content.Context
import android.widget.Toast
import com.example.proyectfinalds6.Models.NewsApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RequestManager(private val context: Context) {

    interface CallNewsApi {
        @GET("top-headlines")
        fun callHeadlines(
            @Query("country") country: String,
            @Query("category") category: String?,
            @Query("q") q: String?,
            @Query("apiKey") apiKey: String
        ): Call<NewsApiResponse>
    }

    fun getNewsHeadlines(listener: OnFetchDataListener<NewsApiResponse>, category: String?, query: String?) {
        val callNewsApi = retrofit.create(CallNewsApi::class.java)
        val call = callNewsApi.callHeadlines("us", category, query, context.getString(R.string.apy_key))

        try {
            call.enqueue(object : Callback<NewsApiResponse> {
                override fun onResponse(call: Call<NewsApiResponse>, response: Response<NewsApiResponse>) {
                    if (!response.isSuccessful) {
                        Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show()
                    }
                    listener.onFetchData(response.body()?.articles ?: emptyList(), response.message())
                }

                override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                    listener.onError("Request Failed")
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}