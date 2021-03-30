package com.skileld.android.newsapptest.api

import com.skileld.android.newsapptest.model.NewsResponse
import com.skileld.android.newsapptest.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        countryCode: String = "ru",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

//    @GET("v2/top-headlines")
//    suspend fun getNews(
//        @Query("country")
//        countryCode: String = "ru",
//        @Query("page")
//        pageNumber: Int = 1,
//        @Query("apiKey")
//        apiKey: String = API_KEY
//    ): Response<NewsResponse>
}