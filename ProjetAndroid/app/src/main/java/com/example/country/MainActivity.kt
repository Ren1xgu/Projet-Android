package com.example.country

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.country.util.*
import java.lang.Exception
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var rvList : RecyclerView
    lateinit var edtSearch : EditText
    lateinit var tvCollection : TextView
    lateinit var tvNoData : TextView
    lateinit var adapter : CountryRvAdapter
    private var databaseHelper: DatabaseHelper? = null
    private val allList: ArrayList<Country> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 控件绑定
        rvList = findViewById(R.id.rvList)
        edtSearch = findViewById(R.id.edtSearch)
        tvCollection = findViewById(R.id.tvCollection)
        tvNoData = findViewById(R.id.tvNoData)
        rvList.layoutManager=LinearLayoutManager(this)
        databaseHelper = DatabaseHelper(this)
        adapter= CountryRvAdapter(arrayListOf(),this,tvNoData, databaseHelper!!)
        rvList.adapter=adapter;
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (!TextUtils.isEmpty(s.toString())){
                    adapter.setList(searchCountriesByName(s.toString()))
                }else{
                    adapter.setList(allList)
                }
            }
            override fun afterTextChanged(s: Editable) {}
        })
        tvCollection.setOnClickListener {

            val intent = Intent(this, CollectionActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        allList.clear()
        adapter.mList.clear()
        Country.getCountry(databaseHelper,adapter,allList)
    }

    private fun searchCountriesByName(s: String): ArrayList<Country> {
        val objects = ArrayList<Country>()
        for (c in adapter.mList) {
            try {
                if (c.name.contains(s)||c.capital.contains(s)) {
                    objects.add(c)
                }
            }catch (e:Exception){
                Log.d("TAG",e.toString()+"\n"+c.toString())
            }
        }
        return objects;

    }


}