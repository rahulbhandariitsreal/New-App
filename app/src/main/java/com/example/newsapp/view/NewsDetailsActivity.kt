package com.example.newsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsDetailsBinding
import com.example.newsapp.model.News

class NewsDetailsActivity : AppCompatActivity() {
    private var news: News? = null
    private lateinit var activityNewsDetailsBinding: ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        activityNewsDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_details)
        val i = intent
        if (i.hasExtra("news")) {
            news = intent.getParcelableExtra("news")
            activityNewsDetailsBinding.setNewsDetails(news)
            supportActionBar!!.setTitle(news!!.title)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }
}