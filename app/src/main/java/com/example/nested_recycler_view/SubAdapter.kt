package com.example.nested_recycler_view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_sub.view.*

class SubAdapter(
    val subHeadingData: MainHeadingData

) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return subHeadingData.subData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvSubType?.text = subHeadingData.subData.get(position).subHeading
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_sub, parent, false))
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvSubType = view.tvSub
}
