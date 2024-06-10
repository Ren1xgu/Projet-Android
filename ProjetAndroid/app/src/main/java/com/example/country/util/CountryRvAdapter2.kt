package com.example.country.util

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.country.R


class CountryRvAdapter2(var mList: ArrayList<Country>, var context:Context, var tvNoData:TextView, var databaseHelper:DatabaseHelper, var myClickListener:MyClickListener) : RecyclerView.Adapter<CountryRvAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_country,parent,false)
        val holder  =  ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    public fun setList(list:ArrayList<Country>) {
        mList.clear()
        if (list.size==0){
            tvNoData.visibility=View.VISIBLE
        }else{
            tvNoData.visibility=View.GONE
            mList.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var country : Country = mList.get(position)
        holder.countryName?.setText(country.name)
        holder.capital?.setText(country.capital)
        if (country.bookmark==1){
            holder.ivBookmark?.setColorFilter(Color.parseColor("#f4ea2a"));
        }else{
            holder.ivBookmark?.setColorFilter(Color.parseColor("#000000"));
        }
        Glide.with(context).load(country.nationalflag).into(holder.ivMap!!)
        holder.ivBookmark?.setOnClickListener {
            myClickListener.onClick(country)

        }
    }

    class ViewHolder : RecyclerView.ViewHolder{
        var countryName : TextView? = null
        var capital : TextView? = null
        var ivBookmark : ImageView? = null
        var ivMap : ImageView? = null
        constructor(view : View):super(view){
            countryName = view.findViewById(R.id.country_name)
            capital = view.findViewById(R.id.capital)
            ivBookmark = view.findViewById(R.id.iv_collection)
            ivMap = view.findViewById(R.id.iv_map)

        }
    }
    interface MyClickListener {
        fun onClick(c:Country)
    }

}