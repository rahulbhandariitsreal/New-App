package com.example.newsapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newsapp.R
import com.example.newsapp.adapter.Myadapter
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.model.News
import com.example.newsapp.viewmodel.ViewmodelNews

@SuppressLint("ResourceType")
class MainActivity : AppCompatActivity() {
    private var category: String? = null
    private lateinit var activityMainBinding: ActivityMainBinding
    private var newsArrayList: ArrayList<News?>? = null
    private var viewmodelNews: ViewmodelNews? = null
    private var myadapter: Myadapter? = null
    private var clickHandlers: MainActivityClickHandlers? = null
    private val selectedcategory = arrayOf(
        "general",
        "health", "science", "sports",
        "technology",
        "business",
        "entertainment"
    )
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodelNews = ViewModelProvider(this).get(ViewmodelNews::class.java)
        val categoryArrayAdapter = ArrayAdapter(this, R.layout.spinner_item, selectedcategory)
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        activityMainBinding.setSpinnerapdapter(categoryArrayAdapter)


        //handlers
        clickHandlers = MainActivityClickHandlers(this)
        activityMainBinding.setClickHandlers(clickHandlers)
        swipeRefreshLayout = activityMainBinding.swipeLayout
        swipeRefreshLayout!!.setColorSchemeResources(R.color.teal_200)
        swipeRefreshLayout!!.setOnRefreshListener { getnews(category) }
    }

    private fun getnews(category: String?) {
        viewmodelNews!!.getListLiveDatanews(category).observe(this) { news ->
            newsArrayList = news as ArrayList<News?>
            setRecyclerview()
        }
    }

    private fun setRecyclerview() {
        recyclerView = activityMainBinding!!.NVrecycler
        myadapter = Myadapter(newsArrayList, this)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = myadapter
        myadapter!!.notifyDataSetChanged()
    }

    inner class MainActivityClickHandlers(var context: Context) {
        fun onSelectItem(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            category = parent.getItemAtPosition(pos) as String
            getnews(category)
        }
    }
}