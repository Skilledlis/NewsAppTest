package com.skileld.android.newsapptest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.onNavDestinationSelected
import com.skileld.android.newsapptest.R
import com.skileld.android.newsapptest.ui.NewsActivity
import com.skileld.android.newsapptest.ui.NewsViewModel
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleFragment : Fragment() {

    lateinit var viewModel: NewsViewModel

    private lateinit var webView: WebView
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        webView = view.findViewById(R.id.articleWebView) as WebView


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()


        (activity as AppCompatActivity).supportActionBar?.apply {
            title = article.title
            setDisplayHomeAsUpEnabled(true)
        }

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
    }



}