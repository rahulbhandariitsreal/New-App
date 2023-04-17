package com.example.newsapp.model

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.R
import com.example.newsapp.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryNews(private val application: Application) {
    //data
    private var newsArrayList = ArrayList<News>()
    private val mutableLiveDatanews = MutableLiveData<List<News>>()
    fun getMutableLiveDatanews(category: String?): MutableLiveData<List<News>> {

        val newsservice = RetrofitInstance.getNewsservice()
        val call = newsservice.getResult(
            category,
            application.applicationContext.getString(R.string.api_key)
        )

        try {
            call.enqueue(object : Callback<Result?> {
                override fun onResponse(call: Call<Result?>, response: Response<Result?>) {
                    if (!response.isSuccessful) {
                    }
                    val result = response.body()
                    if (result != null && result.articles != null) {
                        newsArrayList = result.articles as ArrayList<News>
                        mutableLiveDatanews.value = newsArrayList
                    }
                }

                override fun onFailure(call: Call<Result?>, t: Throwable) {
                    Toast.makeText(
                        application.applicationContext,
                        "unsuccesfull",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        } catch (e: Exception) {
            Log.v("Tag", "Url error")
            e.printStackTrace()
        }
        return mutableLiveDatanews
    }
}