package com.skileld.android.newsapptest.repository

import com.skileld.android.newsapptest.api.RetrofitInstance

class NewsRepository {

    suspend fun getNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getNews(countryCode, pageNumber)
}