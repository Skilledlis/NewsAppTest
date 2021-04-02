package com.skileld.android.newsapptest.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.skileld.android.newsapptest.R
import com.skileld.android.newsapptest.ui.NewsActivity
import com.skileld.android.newsapptest.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.view.*
import java.io.Serializable

class ArticleFragment : Fragment()  {

    lateinit var viewModel: NewsViewModel

//    private lateinit var webView: WebView
    private lateinit var contentTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var urlTextView: TextView
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)
//        webView = view.findViewById(R.id.articleWebView) as WebView
        contentTextView = view.findViewById(R.id.textContent) as TextView
        titleTextView = view.findViewById(R.id.articleTitle) as TextView
        imageView = view.findViewById(R.id.imageView) as ImageView
        urlTextView = view.findViewById(R.id.textUrl) as TextView
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


        titleTextView.apply {
            text = article.title
        }

        Glide.with(this).load(article.urlToImage).into(imageView)

        contentTextView.apply {
            text = article.description
        }

        urlTextView.apply {
            setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(article.url)))
            }
        }





    }



}