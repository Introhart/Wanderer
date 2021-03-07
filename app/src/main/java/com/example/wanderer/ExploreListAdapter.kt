package com.example.wanderer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class ExploreListAdapter(private var itemsList : List<String>) : RecyclerView.Adapter<ExploreListAdapter.ViewHolder>() {

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.explore_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = itemsList[position]
        holder.itemTextView.text = item
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}