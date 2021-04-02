package com.skileld.android.newsapptest.model

import com.skileld.android.newsapptest.model.Article
import java.io.Serializable

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
) : Serializable