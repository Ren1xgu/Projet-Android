package com.example.country

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.country.util.*
import com.example.country.util.CountryRvAdapter2.MyClickListener


class CollectionActivity : AppCompatActivity() {
    lateinit var rvList : RecyclerView
    lateinit var tvCollection : TextView
    lateinit var tvNoData : TextView
    lateinit var adapter : CountryRvAdapter2
    private var databaseHelper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        // 控件绑定
        rvList = findViewById(R.id.rvList)
        tvCollection = findViewById(R.id.tvCollection)
        tvNoData = findViewById(R.id.tvNoData)
        rvList.layoutManager=LinearLayoutManager(this)
        databaseHelper = DatabaseHelper(this)
        adapter= CountryRvAdapter2(
            arrayListOf(),this,tvNoData,
            databaseHelper!!, object : MyClickListener {
                override fun onClick(country:Country) {
                    if (country.bookmark==0){
                        country.bookmark=1
                        Toast.makeText(this@CollectionActivity,"Bookmarking success!", Toast.LENGTH_SHORT).show()

                    }else{
                        country.bookmark=0
                        Toast.makeText(this@CollectionActivity,"Bookmark cancelled！！", Toast.LENGTH_SHORT).show()

                    }
                    databaseHelper!!.updateCountry(country)
                    val bookmarkedCountries = databaseHelper!!.bookmarkedCountries
                    adapter.setList(bookmarkedCountries)
                }
            }
        )
        rvList.adapter=adapter;
        val bookmarkedCountries = databaseHelper!!.bookmarkedCountries
        adapter.setList(bookmarkedCountries)
        tvCollection.setOnClickListener {
            finish()
        }
    }

}