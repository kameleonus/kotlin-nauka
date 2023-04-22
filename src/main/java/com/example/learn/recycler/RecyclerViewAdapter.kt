package com.example.learn.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learn.R
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Adapter listy odzyskiwanej obiektu diety
 */
class RecyclerViewAdapter(private var items:ArrayList<Pair<String, String>>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val li = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return object : RecyclerView.ViewHolder(li){}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.header.text=items[position].first
        holder.itemView.body.text=items[position].second

    }

    override fun getItemCount(): Int = items.count()


}